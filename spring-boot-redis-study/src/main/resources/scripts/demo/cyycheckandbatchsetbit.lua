-- KEYS说明
-- 1:缓存Key
-- ARGV说明
-- 置位

-- 先检查
for i,key in ipairs(KEYS) do
    local value = ARGV[i]
    local prefix = string.sub(value,1,5)
    local bitv = 1
    if prefix == 'fbit:' then
        bitv =0
    end
    for seatno in string.gmatch(value, "%d+") do
        -- 此处需要校验下；
        local ret = redis.call('getbit',key,seatno)
        -- 如果一样则
        if ret == bitv then
            return -1
        end
    end
end

for i,key in ipairs(KEYS) do
    local value = ARGV[i]
    local prefix = string.sub(value,1,5)
    local bitv = 1
    if prefix == 'fbit:' then
        bitv =0
    end
    for seatno in string.gmatch(value, "%d+") do
        redis.call('setbit',key,seatno,bitv)
    end
end

return 0