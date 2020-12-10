package com.ncepu.cloudyilaboratory.leetcode.inorderpostorderbinarytree;

import java.util.HashMap;
import java.util.Map;

import com.ncepu.cloudyilaboratory.binarysearchtree.BTreePrinter;

public class InorderPostOrderBinaryTreeV3 {
    int post_idx;
    int[] postOrder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postOrder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postOrder = new int[] {9,15,7,20,3};

        /*int[] inorder = new int[] {4,9,5,3,15,20,7};
        int[] postOrder = new int[] {4,5,9,15,7,20,3};*/

        /*int[] inorder = new int[] {10,4,25,9,6,5,13,3,15,20,7};
        int[] postOrder = new int[] {10,25,4,6,13,5,9,15,7,20,3};*/

        TreeNode treeNode = new InorderPostOrderBinaryTreeV3().buildTree(inorder, postOrder);
        BTreePrinter.printNode(treeNode);
    }
}
