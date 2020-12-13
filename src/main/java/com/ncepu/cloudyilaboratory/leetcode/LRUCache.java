package com.ncepu.cloudyilaboratory.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LRUCache<K, V> {

    class Entity {
        private K key;
        private V value;

        public Entity() {}

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer limit = -1;

    private Deque<Entity> cacheQueue = new LinkedList<>();

    public LRUCache() {}

    public LRUCache(int limit) {
        this.limit = limit;
    }

    public void insert(K key, V value) {
        Entity tempEntity = null;
        for (Entity entity : cacheQueue) {
            if (key.equals(entity.key)) {
                entity.value = value;
                tempEntity = entity;
                break;
            }
        }

        if (tempEntity != null) {
            cacheQueue.remove(tempEntity);
            cacheQueue.addLast(tempEntity);
        } else {
            if (limit != -1 && cacheQueue.size() >= limit) {
                cacheQueue.removeFirst();
            }

            Entity newEntity = new Entity(key, value);
            cacheQueue.addLast(newEntity);
        }
    }

    public V get(K key) {
        Entity tempEntity = null;
        for (Entity entity : cacheQueue) {
            if (key.equals(entity.key)) {
                tempEntity = entity;
                break;
            }
        }
        if (tempEntity != null) {
            cacheQueue.remove(tempEntity);
            cacheQueue.addLast(tempEntity);
            return tempEntity.value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
