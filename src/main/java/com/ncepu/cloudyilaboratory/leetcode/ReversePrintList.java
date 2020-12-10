package com.ncepu.cloudyilaboratory.leetcode;

public class ReversePrintList {

    private class ListNode {
        int value;
        ListNode next;

        public ListNode() {}

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListNode generateList() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);
        return head;
    }

    public void printList(ListNode head) {
        if (head.next != null) {
            printList(head.next);
        }
        System.out.print(head.value + "<-");
    }

    public static void main(String[] args) {
        ReversePrintList printList = new ReversePrintList();
        printList.printList(printList.generateList());
    }
}
