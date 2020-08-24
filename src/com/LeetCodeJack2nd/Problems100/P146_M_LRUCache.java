package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P146_M_LRUCache {
    int size;
    Deque<Integer> cache;
    Map<Integer, Integer> dic;

    public P146_M_LRUCache(int capacity) {
        dic = new HashMap<>();
        cache = new LinkedList<>();
        size = capacity;

    }

    public int get(int key) {
        if (!dic.containsKey(key))
            return -1;
        else {
            cache.remove(key);
            cache.addFirst(key);
            return dic.get(key);
        }
    }

    public void put(int key, int value) {
        if (cache.size() >= size) {
            // System.out.println(cache.getLast());
            if (dic.containsKey(key)) {
                cache.remove(key);
            } else {
                dic.remove(cache.getLast());
                cache.removeLast();
            }
        }else{
            if (dic.containsKey(key))
                cache.remove(key);
        }
        cache.addFirst(key);
        dic.put(key, value);
    }
}
