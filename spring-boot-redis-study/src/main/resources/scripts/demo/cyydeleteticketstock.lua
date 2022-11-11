-- KEYS说明
-- ticketID对应的key
-- ARGV说明
-- 对应删除的仓ID
-- 删除的预留仓库存要回归到共享仓
for i,k in ipairs(KEYS) do
    local v = ARGV[i]
    local q = tonumber(redis.call('hget',k,v))
    redis.call('HDEL',k,v)
    if q~=nil and q >0 then
        -- 如果待删除的预留仓中有库存，则需要转移到共享仓中；
        redis.call('HINCRBY',k,'shareStock',tonumber(q))
    end
end
return 0