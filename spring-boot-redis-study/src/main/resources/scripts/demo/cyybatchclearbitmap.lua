-- KEYS说明
-- 1:缓存Key
-- 2:填充值（0/1）
-- 3:arg对应设置的值：（0/1）
-- ARGV说明
-- 置位

local k = KEYS[1]
local b='\0'
for i,k in ipairs(KEYS) do
    local sl = redis.call('STRLEN',k)
    redis.call('SETRANGE', k, 0, string.rep(b, sl))
end
return 0