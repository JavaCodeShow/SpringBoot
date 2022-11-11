-- KEYS说明
-- 1:缓存Key
-- ARGV说明
-- 置位
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
