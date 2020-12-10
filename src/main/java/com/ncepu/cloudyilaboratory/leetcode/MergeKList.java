package com.ncepu.cloudyilaboratory.leetcode;

import java.util.PriorityQueue;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length,
                (ListNode a, ListNode b) -> a.val - b.val);
        ListNode result = new ListNode();
        ListNode head = result;

        for (int i = 0; i < lists.length; i++) {
            priorityQueue.add(lists[i]);
        }

        do {
            ListNode node = priorityQueue.poll();
            result.next = new ListNode(node.val);
            result = result.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        } while(!priorityQueue.isEmpty());

        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode lists11 = new ListNode(1);
        ListNode lists12 = new ListNode(4);
        ListNode lists13 = new ListNode(5);
        lists11.next = lists12;
        lists12.next = lists13;
        lists[0] = lists11;

        ListNode lists21 = new ListNode(1);
        ListNode lists22 = new ListNode(3);
        ListNode lists23 = new ListNode(4);
        lists21.next = lists22;
        lists22.next = lists23;
        lists[1] = lists21;

        ListNode lists31 = new ListNode(2);
        ListNode lists32 = new ListNode(6);
        lists31.next = lists32;
        lists[2] = lists31;

        ListNode listNode = new MergeKList().mergeKLists(lists);

        while(listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


