-- 清空指定仓同步扣减总仓数据；
-- KEYS  ticket总仓KEY
-- ARGV  ticket分仓KEY=仓ID

local function hashkv(value)
	local s,e = string.find(value,"=")
	local hk = string.sub(value,1,s-1)
	local hv = string.sub(value,e+1)
	return hk,hv
end

local ret={}
for i,k in ipairs(KEYS) do
    local seatPlanKey,ticketId=hashkv(KEYS[i])
    local ticketStockKey,stockId=hashkv(ARGV[i])
    local stockQty=tonumber(redis.call('hget',ticketStockKey,stockId))
    if stockQty ~= 0 then
        -- 总仓，分仓一起减
        redis.call('hincrby',ticketStockKey,stockId,stockQty * -1)
        redis.call('hincrby',seatPlanKey,ticketId,stockQty * -1)
    end
    ret[i]=stockQty
end
return ret

