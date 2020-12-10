package com.ncepu.cloudyilaboratory.leetcode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = 0;

        ListNode temp = head;
        ListNode nextGroupHead = null;
        while (temp != null) {
            count++;
            if (count == k) {
                nextGroupHead = reverseKGroup(temp.next, k);
                break;
            }
            temp = temp.next;
        }

        if (count < k) {
            return head;
        }

        ListNode p1 = head.next;
        ListNode p2 = head;
        p2.next = nextGroupHead;

        count = 1;
        while (count < k) {
            temp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = temp;
            count++;
        }
        return p2;
    }
}
