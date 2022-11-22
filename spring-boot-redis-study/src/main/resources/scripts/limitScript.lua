--在xxx分钟内访问这个key达到了xxx次,返回某个值
local times = redis.call('incr',KEYS[1])
if times == 1 then
    redis.call('expire',KEYS[1],ARGV[1])
end
if times > tonumber(ARGV[2]) then
    return 'a'
end
return 'b'