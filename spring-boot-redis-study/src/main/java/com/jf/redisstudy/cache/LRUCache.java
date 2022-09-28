package com.jf.redisstudy.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU（Least recently used，最近最少使用）
 * 算法根据数据的历史访问记录来进行淘汰数据，
 * 其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高, 如果数据最近没有被访问过，那么以后也可能不会访问”,
 */
public class LRUCache {

    int capacity;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        // 超出capacity，删除最久没用的,利用迭代器删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
