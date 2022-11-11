-- KEYS说明
-- ticketID对应的key
-- ARGV说明
-- 仓ID=qty

local function hashkv(value)
	local s,e = string.find(value,"=")
	local hk = string.sub(value,1,s-1)
	local hv = string.sub(value,e+1)
	return hk,hv
end

-- 检查共享仓库存是否够预留的。
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    local hk,hv=hashkv(v)
    local hv1=tonumber(hv)
    local s = tonumber(redis.call('HGET',k,'shareStock'))
    if s < tonumber(hv) then
        -- 如果共享仓剩余的库存比新建的预留仓还要小，则无法完成预留。也就终止。
        return -1
    end
end

-- 新建的预留仓库存要从共享仓出
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    local hk,hv=hashkv(v)
    local hv1=tonumber(hv)
    redis.call('HSET',k,hk,hv1)
    if hv1>0 then
        redis.call('HINCRBY',k,'shareStock', hv1 * -1)
    end
end
return 0