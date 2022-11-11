local objRet = {}
local function shsh(value)
	local s,e = string.find(value,"=")
	local keys = string.sub(value,6,s-1)
	local v = string.sub(value,e+1)
	local stockIds={}
	local seq=","
	for word in string.gmatch(keys,"[^{"..seq.."}*]+") do
		table.insert(stockIds,word)
	end
	return stockIds,v
end

local function hashkv(value)
	local s,e = string.find(value,"=")
	local hk = string.sub(value,6,s-1)
	local hv = string.sub(value,e+1)
	return hk,hv
end

local function setbit(key,value,bit)
    for seatno in string.gmatch(value, "%d+") do
        redis.call('setbit',key,seatno,bit)
    end
end

local function setbitfastfail(key,value,bit)
    local idx=0
    local failidx=0
    for seatno in string.gmatch(value, "%d+") do
        idx=idx+1
        local ret=redis.call('setbit',key,seatno,bit)
        if ret==bit and bit==0 then
            failidx=idx
            break;
        end
    end
    if failidx >0 then
        idx=0
        local rbit=1
        if bit==1 then
            rbit=0
        end
        for seatno in string.gmatch(value, "%d+") do
            idx=idx+1
            if idx >= failidx then
                break
            end
            redis.pcall('setbit',key,seatno,rbit)
        end
    end
    return failidx
end

local function selectstock(key,value)
    local ids,qty=shsh(value)
    local shshret={}
    local lqty = tonumber(qty)
    for s ,id in ipairs(ids) do
        local r = redis.call('hget',key,id)
        if r ~=nil and tonumber(r) >0 then
           local r1= tonumber(r)
           if lqty<r1 then
                r1=lqty
           end
           redis.call('hincrby',key,id, r1 * -1)
           lqty=lqty-r1
           shshret[s]=r1
        else
           shshret[s]=0
        end
        if lqty <=0 then
            break
        end
    end
    if lqty>0 then
        for s,qty in ipairs(shshret) do
            if tonumber(qty)>0 then
                redis.call('hincrby',key,ids[s], qty)
            end
        end
    end
    return shshret,lqty
end

local ret=0
local bitret=0
for i,value in pairs(ARGV) do
	local prefix = string.sub(value,1,5)
	local key=KEYS[i]
	if prefix == 'hash:' then
	    local hk,hv=hashkv(value)
        local qtyret=redis.call('hincrby',key,hk,tonumber(hv))
        if qtyret < 0 then
            ret=i
            redis.call('hincrby',key,hk,tonumber(hv) * -1)
            break
        end
        objRet[i]=0
    elseif prefix == 'shsh:' then
        local slet,lqty = selectstock(key,value)
        if lqty >0 then
            ret=i
            break
        end
        objRet[i]=slet
	elseif prefix == 'tbit:' or prefix== 'fbit:' then
	    local bitv = 1
	    if prefix == 'fbit:' then
	        bitv = 0
	    end
	    bitret = setbitfastfail(key,value,bitv)
        if bitret > 0 then
            ret=i
            break
        end
        objRet[i]=0
    elseif prefix == 'lmax:' then
        local qty=tonumber(redis.call("get",key))
        local lmax = tonumber(string.sub(value,6))
        if qty > lmax then
            ret=i
            break
        end
         objRet[i]=0
	else
	    local qtyret=redis.call('incrby',key,tonumber(value))
	    if qtyret < 0 then
            ret=i
            redis.call('decrby',key,tonumber(value))
            break
        end
        objRet[i]=0
	end
end

-- 如果ret>0表示有提前终止，则意味着执行失败了。需要回滚之前的操作；
if ret>0 then
	for i=1,ret-1 do
		local value=ARGV[i]
		local key=KEYS[i]
		local prefix = string.sub(value,1,5)
        if prefix == 'hash:' then
            local hk,hv=hashkv(value)
            redis.pcall('hincrby',key,hk,tonumber(hv)*-1)
        elseif prefix == 'shsh:' then
            local ids,qty=shsh(value)
            local lret=objRet[i]
            for s,qty in ipairs(lret) do
               redis.pcall('hincrby',key,ids[s],qty)
            end
        elseif prefix == 'tbit:' or prefix== 'fbit:' then
            local bitv = 0
            if prefix == 'fbit:' then
                bitv = 1
            end
            setbit(key,value,bitv)
        elseif prefix=='lmax:' then
        else
            redis.pcall('decrby',key,tonumber(value))
        end
	end
end
return objRet