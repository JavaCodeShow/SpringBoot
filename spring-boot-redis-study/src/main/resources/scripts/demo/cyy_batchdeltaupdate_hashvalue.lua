-- KEYS说明：redisKey
-- ARGV说明  hashKey={delta}
local function hashkv(value)
	local s,e = string.find(value,"=")
	local hk = string.sub(value,1,s-1)
	local hv = string.sub(value,e+1)
	return hk,hv
end
local failIdx = 0
for i,k in ipairs(KEYS) do
    local hkey,delta=hashkv(ARGV[i])
    local ret = redis.call('HINCRBY',k,hkey, tonumber(delta))
    if tonumber(ret) < 0 then
        -- 库存不能扣减到0；
        failIdx = i
        break
    end
end
-- failIdx 大于0表示有回滚
if failIdx > 0 then
    for i=1,failIdx do
        local hkey,delta=hashkv(ARGV[i])
        redis.pcall('HINCRBY',KEYS[i],hkey, tonumber(delta) * -1)
    end
end
return failIdx