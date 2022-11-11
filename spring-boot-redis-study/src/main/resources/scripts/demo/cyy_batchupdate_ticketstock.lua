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

local failIdx = 0
-- 检查共享仓库存是否够预留的。
for i,k in ipairs(KEYS) do
    local stockId,delta=hashkv(ARGV[i])
    local ret = redis.call('HINCRBY',k,stockId, tonumber(delta))
    if tonumber(ret) < 0 then
        -- 库存不能扣减到0；
        failIdx = i
        break
    end
end

if failIdx > 0 then
    for i=1,failIdx do
        local stockId,delta=hashkv(ARGV[i])
        redis.pcall('HINCRBY',KEYS[i],stockId, tonumber(delta) * -1)
    end
end

return failIdx