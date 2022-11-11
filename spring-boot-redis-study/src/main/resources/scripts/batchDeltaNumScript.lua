--对一批key同时做delta值计算
-- KEYS说明：key的名称
-- ARGV说明：delta值
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    redis.call('INCRBY',k,v)
end