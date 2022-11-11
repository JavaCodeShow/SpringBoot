-- KEYS说明
-- 1:缓存Key
-- 2:填充值（0/1）
-- 3:arg对应设置的值：（0/1）
-- ARGV说明
-- 置位

local k = KEYS[1]
local v = tonumber(KEYS[2])
-- 先将已存在的bitmap置位（0/1）
local sl = redis.call('STRLEN',k)
if sl > 0 then
  local b = '\255'
  if 0 == v then
    b = '\0'
  end
  redis.call('SETRANGE', k, 0, string.rep(b, sl))
end

-- 将指定下标调整为特定值
for i,seatno in ipairs(ARGV) do
    redis.call('SETBIT', k, seatno, tonumber(KEYS[3]))
end

return 1
