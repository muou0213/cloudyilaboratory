package com.ncepu.cloudyilaboratory.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LruCacheV2<K, V> {

    class Entity {
        private K key;
        private V value;
        private Entity next, pre;

        public Entity() {}

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer limit;
    private Map<K, Entity> contentMap = new HashMap<>();
    private Entity head, tail;

    public LruCacheV2() {}

    public LruCacheV2(int limit) {
        this.limit = limit;
    }

    public void insert(K key, V value) {
        // 如果key已经存在则进行覆盖，否则进行添加
        // 在需要添加的情况下，如果当前的元素个数已经等于limit，则删除最久没有访问的元素
        Entity entity = contentMap.get(key);
        if (entity != null) {
            entity.value = value;
//            contentMap.put(key, entity);
            moveToTail(entity);
        } else {
            if (contentMap.size() >= limit) {
                Entity tempEntity = head;
                head = tempEntity.next;
                head.pre = null;

                contentMap.remove(tempEntity.key);
            }

            Entity newEntity = new Entity(key, value);
            contentMap.put(key, newEntity);
            insertToTail(newEntity);
        }
    }

    public V get(K key) {
        Entity entity = contentMap.get(key);
        if (entity == null) {
            return null;
        } else {
            moveToTail(entity);
            return entity.value;
        }

    }

    private void moveToTail(Entity entity) {
        if (head == null && tail == null) {
            head = entity;
            tail = entity;
        }
        if (entity.next == null) {
            return;
        } else {
            if (entity == head) {
                head = entity.next;
            }
            entity.next.pre = entity.pre;
        }
        if (entity.pre != null) {
            entity.pre.next = entity.next;
        }
        tail.next = entity;
        entity.pre = tail;
        tail = entity;
    }

    private void insertToTail(Entity entity) {
        if (head == null && tail == null) {
            head = entity;
            tail = entity;
        }

        tail.next = entity;
        entity.pre = tail;
        tail = entity;
    }

    public void print(){
        Collection<Entity> values = contentMap.values();
        Iterator it = values.iterator();
        while(it.hasNext()){
            Entity entity = (Entity) it.next();
            System.out.println(entity.key + "  :  " + entity.value);
        }
    }

    public static void main(String[] args) {
        LruCacheV2<String, String> cache = new LruCacheV2<>(2);
        cache.insert("one", "1");
        cache.insert("tow", "2");
        cache.get("one");
        cache.print();

        cache.insert("three", "3");
        cache.print();
    }
}
