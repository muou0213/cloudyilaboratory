package com.ncepu.cloudyilaboratory.leetcode.inorderpostorderbinarytree;

import com.ncepu.cloudyilaboratory.binarysearchtree.AVLTreeNodeInterface;

public class TreeNode implements AVLTreeNodeInterface {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public AVLTreeNodeInterface getLeftChild() {
        return left;
    }

    @Override
    public AVLTreeNodeInterface getRightChild() {
        return right;
    }

    @Override
    public int getValue() {
        return val;
    }
}
