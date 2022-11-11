package com.jf.redisstudy.lua;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Configuration
@Slf4j
public class StoreRedisScriptConfigration {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean(CacheConsts.LUA_BATCH_DELTA_NUM)
    public DefaultRedisScript<String> initBatchDeltaNumScriptScript() {
        return initScript("/scripts/batchDeltaNumScript.lua");
    }

    private DefaultRedisScript<String> initScript(String scriptPath) {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(scriptPath)));
        redisScript.setResultType(String.class);
        loadRedisScriptToServer(redisScript, scriptPath);
        return redisScript;
    }

    private void loadRedisScriptToServer(DefaultRedisScript<String> redisScript, String luaName) {
        try {
            List<Boolean> results = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().scriptExists(redisScript.getSha1());
            assert results != null;
            if (Boolean.FALSE.equals(results.get(0))) {
                String sha = redisTemplate.getConnectionFactory().getConnection().scriptLoad(scriptBytes(redisScript));
                log.info("预加载lua脚本成功:{},sha:{}", luaName, sha);
            } else {
                log.info("lua脚本之前已经预加载:{},sha:{}", luaName, redisScript.getSha1());
            }
        } catch (Exception e) {
            log.error("预加载Lua脚本异常：{}", luaName, e);
        }
    }

    private byte[] scriptBytes(RedisScript<?> redisScript) {
        return this.redisTemplate.getStringSerializer().serialize(redisScript.getScriptAsString());
    }
}
