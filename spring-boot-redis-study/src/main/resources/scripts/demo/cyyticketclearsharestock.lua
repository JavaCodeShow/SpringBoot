
-- 脚本说明：清除端票价下 制定ticket 的剩余数量为0，并返回清除了多少

-- KEYS说明
-- 1:端票价Key
-- 2:ticket分仓key

-- ARGV
-- 1，ticketId
local ticketKey=KEYS[2]
local seatPlanKey=KEYS[1]
local ticketId=ARGV[1]
local shareStockQty=tonumber(redis.call('hget',ticketKey,'shareStock'))
if shareStockQty > 0 then
    redis.call('hset',ticketKey,'shareStock','0')
    redis.call('hincrby',seatPlanKey,ticketId,shareStockQty * -1)
    return shareStockQty
end
return 0
