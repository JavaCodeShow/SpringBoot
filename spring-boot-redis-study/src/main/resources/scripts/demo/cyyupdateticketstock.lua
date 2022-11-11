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
local key = KEYS[1]
local hk,hv=hashkv(ARGV[1])
local hv1=tonumber(hv)

local qty = tonumber(redis.call('HGET',key,hk))
if qty+tonumber(hv1) <0 then
    return qty
end
redis.call('HINCRBY',key,hk,hv1)
redis.call('HINCRBY',key,'shareStock',hv1 * -1)
return 0
