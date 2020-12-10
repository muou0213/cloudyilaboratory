package com.ncepu.cloudyilaboratory.leetcode;

public class MergeTwoList {
    private class Node {
        private int value = 0;
        private Node next;

        public Node() {}

        public Node(Integer value) {
            this.value = value;
        }
    }

    public Node merge (Node head1, Node head2) {
        if (head1 == null) {
            if (head2 == null) {
                throw new IllegalArgumentException("head1 and head2 can not both be null");
            } else {
                return head2;
            }
        }

        if (head2 == null) {
            return head1;
        }

        Node temp = new Node(), result = temp;

        while (head1!= null || head2 != null) {
            if (head2 == null || head1.value <= head2.value) {
                temp.next = new Node(head1.value);
                head1 = head1.next;
            } else if(head1 == null || head1.value > head2.value) {
                temp.next = new Node(head2.value);
                head2 = head2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public Node generateNodeList(Integer[] integers) {
        Node result = new Node(), temp = result;
        for (int i = 0 ; i < integers.length; i++) {
            temp.next = new Node(integers[i]);
            temp = temp.next;
        }
        return result.next;
    }

    public String printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        Node temp = node;
        while (temp != null) {
            sb.append(temp.value + "->");
            temp = temp.next;
        }

        return sb.substring(0, sb.length()-2);
    }
    public static void main(String[] args) {
        MergeTwoList sort = new MergeTwoList();

        Integer[] integers1 = new Integer[] {1, 3, 5};
        Integer[] integers2 = new Integer[] {2, 4};

        Node head1 = sort.generateNodeList(integers1);
        Node head2 = sort.generateNodeList(integers2);

        Node mergedNode = sort.merge(head1, head2);

        System.out.println(sort.printNode(mergedNode));
    }
}
