-- KEYS说明
-- 1:缓存Key
-- 2:设置的值（0/1）
-- ARGV说明
-- 置位

local k = KEYS[1]
-- 将指定下标调整为特定值
for i,seatno in ipairs(ARGV) do
    redis.call('SETBIT', k, seatno, tonumber(KEYS[2]))
end
return 1
