-- KEYS说明
-- 1: 缓存key
-- ARGV说明
-- hash结构value


for i, key in ipairs(KEYS) do
    local value = ARGV[i]

end
return 1



local k = KEYS[1]
-- 将指定下标调整为特定值
for i,seatno in ipairs(ARGV) do
    redis.call('SETBIT', k, seatno, tonumber(KEYS[2]))
end
return 1
