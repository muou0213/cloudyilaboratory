package com.ncepu.cloudyilaboratory.leetcode;

public class GetMinDistanceBetweenBSTNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    private int min;

    public int minDiffInBST(TreeNode root) {
        min = root.val;
        minDiffInSubTree(root);
        return min;
    }

    private void minDiffInSubTree(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            TreeNode tempNode = node.right;
            while (tempNode.left != null) {
                tempNode = tempNode.left;
            }
            int rightDiff = tempNode.val - node.val;
            if (min > rightDiff) {
                min = rightDiff;
            }
            minDiffInSubTree(node.right);
        }

        if (node.left != null) {
            TreeNode tempNode = node.left;
            while (tempNode.right != null) {
                tempNode = tempNode.right;
            }
            int leftDiff = node.val - tempNode.val;
            if (min > leftDiff) {
                min = leftDiff;
            }
            minDiffInSubTree(node.left);
            // [4,2,6,1,3,null,null]
        }
    }
}
