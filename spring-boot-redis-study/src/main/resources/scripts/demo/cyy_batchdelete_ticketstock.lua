-- KEYS说明 key
-- ARGV说明 删除仓ID=目标仓IDuudjddjdjdj
local function hashkv(value)
	local s,e = string.find(value,"=")
	local hk = string.sub(value,1,s-1)
	local hv = string.sub(value,e+1)
	return hk,hv
end
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    local delStockId,tagStockId=hashkv(v)
    local r = redis.call('HGET',k,delStockId)
    redis.call('HDEL',k,delStockId)
    if r ~=nil and tonumber(r) >0 then
        redis.call('HINCRBY',k,tagStockId,tonumber(r))
    end
end
return 0