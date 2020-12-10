package com.ncepu.cloudyilaboratory.binarysearchtree;

public class Solution {


    public ListNode swapPairs(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode newHead = head.next;

        ListNode preHead = null;
        ListNode p2 = head;
        ListNode p1 = head.next;

        ListNode tempHead = null;

        int count = 1;
        while (p1 != null) {
            count++;
            if (count == 2) {
                count = 0;
                tempHead = p1.next;
                p1.next = p2;
                p2.next = null;

                
                
                if (preHead != null) {
                    preHead.next = p1;
                }
                preHead = p2;

                p2 = p1;
                p1 = tempHead;

            } else {
                p2 = p1;
                p1 = p1.next;
            }
        }

        if (count == 1) {
            preHead.next = p2;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode listNode = new Solution().swapPairs(node1);
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
