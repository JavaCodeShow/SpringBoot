-- KEYS说明
-- ticketID对应的key
-- ARGV说明
-- 对应删除的仓ID
-- 删除的预留仓库存要回归到共享仓
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    local q = tonumber(redis.call('get',k))
    redis.call('INCRBY',k,v)
end
return 0