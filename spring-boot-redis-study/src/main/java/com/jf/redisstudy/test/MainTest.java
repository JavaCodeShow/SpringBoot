package com.jf.redisstudy.test;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;

public class MainTest {

    public static void main(String[] args) {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(500)
                .recordStats()
                .build(k -> k);

        for (int i = 0; i < 600; i++) {
            cache.get(String.valueOf(i));
            if (i > 500) {
                CacheStats stats = cache.stats();
                System.out.println("evictionCount:" + stats.evictionCount());
                System.out.println("stats:" + stats.toString());
            }
        }

    }
}
