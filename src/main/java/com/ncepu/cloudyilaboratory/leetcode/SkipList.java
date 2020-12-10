package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList<K extends Comparable<K>,V> {
    private List<SkipListNode> heads;

    private class SkipListNode {
        K key;
        V value;
        SkipListNode next,child;

        public SkipListNode() {}

        public SkipListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void add(K key, V value) {
        if (heads == null) {
            heads = new ArrayList<>();
            SkipListNode head = new SkipListNode();
            heads.add(head);
            head.next = new SkipListNode(key, value);
            return;
        }
        int height = heads.size();
        List<SkipListNode> preNodes = new ArrayList(height);

        SkipListNode preNode = heads.get(height - 1), node = preNode.next;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult == 0) {
                node.value = value;
                if (preNode.child == null) {
                    break;
                }
                preNode = preNode.child;
                node = preNode.next;
            } else if(compareResult < 0) { // 要添加的值比较小，向下走
                preNodes.add(preNode);
                if (preNode.child == null) {
                    break;
                }
                preNode = preNode.child;
                node = preNode.next;
            } else { // 要添加的值比较大，向右走
                preNode = node;
                node = node.next;
            }
        }

        int h = height - 1;
        Random r = new Random();
        do {
            if (h == -1) {
                SkipListNode head = new SkipListNode();
                heads.add(head);
                head.next = new SkipListNode(key, value);
                break;
            }
            SkipListNode toAddNode = new SkipListNode(key, value);
            preNode = preNodes.get(h);
            toAddNode.next = preNode.next;
            preNode.next = toAddNode;
            h--;
        } while (h >= -1 && r.nextInt(1) == 0);
    }


    public V get(K key) {
        if (heads == null) {
            return null;
        }
        int height = heads.size();

        SkipListNode preNode = heads.get(height - 1), node = preNode.next;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult == 0) {
                return node.value;
            } else if(compareResult < 0) { // 要添加的值比较小，向下走
                if (preNode.child == null) {
                   return null;
                }
                preNode = preNode.child;
                node = preNode.next;
            } else { // 要添加的值比较大，向右走
                preNode = node;
                node = node.next;
            }
        }
        return null;
    }
}
