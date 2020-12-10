package com.ncepu.cloudyilaboratory.leetcode.inorderpostorderbinarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ncepu.cloudyilaboratory.binarysearchtree.BTreePrinter;

public class InorderPostOrderBinaryTreeV2 {
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        class ValuePosition {
            int value;
            int position;
            int leftPosition;
            int rightPosition;

            public ValuePosition(int value, int position, int leftPosition, int rightPosition) {
                this.value = value;
                this.position = position;
                this.leftPosition = leftPosition;
                this.rightPosition = rightPosition;
            }
        }
        Deque<ValuePosition> valuePositionStack = new ArrayDeque<>(postOrder.length);

        int value = postOrder[postOrder.length - 1];
        Integer position = valueIndexMap.get(value);
        Integer leftPosition = -1;
        Integer rightPosition = inorder.length;
        valuePositionStack.addFirst(new ValuePosition(value, position, leftPosition, rightPosition));
        TreeNode rootNode = new TreeNode(value);
        Map<Integer, TreeNode> valueTreeNodeMap = new HashMap<>();
        valueTreeNodeMap.put(value, rootNode);

        for (int j = postOrder.length - 2; j >=0; j--) {
            value = postOrder[j];
            position = valueIndexMap.get(value);

            Iterator<ValuePosition> valuePositionIterator = valuePositionStack.descendingIterator();
            while(valuePositionIterator.hasNext()) {
                ValuePosition valuePosition = valuePositionIterator.next();
                if (position > valuePosition.rightPosition || position < valuePosition.leftPosition) {
                    continue;
                }
                // 左子树
                if (position < valuePosition.position) {
                    TreeNode parentTreeNode = valueTreeNodeMap.get(valuePosition.value);
                    TreeNode nowTreeNode = new TreeNode(value);
                    parentTreeNode.left = nowTreeNode;
                    valueTreeNodeMap.put(value, nowTreeNode);

                    valuePositionStack.addLast(new ValuePosition(value, position, valuePosition.leftPosition,
                            valuePosition.position));
                    break;
                } else { // 右子树
                    TreeNode parentTreeNode = valueTreeNodeMap.get(valuePosition.value);
                    TreeNode nowTreeNode = new TreeNode(value);
                    parentTreeNode.right = nowTreeNode;
                    valueTreeNodeMap.put(value, nowTreeNode);

                    valuePositionStack.addLast(new ValuePosition(value, position, valuePosition.position,
                            valuePosition.rightPosition));
                    break;
                }
            }
        }
        return rootNode;
    }

    public static void main(String[] args) {
        /*int[] inorder = new int[] {9,3,15,20,7};
        int[] postOrder = new int[] {9,15,7,20,3};*/

        /*int[] inorder = new int[] {4,9,5,3,15,20,7};
        int[] postOrder = new int[] {4,5,9,15,7,20,3};*/

        int[] inorder = new int[] {10,4,25,9,6,5,13,3,15,20,7};
        int[] postOrder = new int[] {10,25,4,6,13,5,9,15,7,20,3};

        TreeNode treeNode = new InorderPostOrderBinaryTreeV2().buildTree(inorder, postOrder);
        BTreePrinter.printNode(treeNode);
    }
}
