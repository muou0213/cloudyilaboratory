package com.ncepu.cloudyilaboratory.leetcode.inorderpostorderbinarytree;

public class InorderPostOrderBinaryTree {
//
/*public TreeNode buildTree(int[] inorder, int[] postOrder) {
    if (inorder == null || inorder.length == 0) {
        return null;
    }
    TreeNode treeNode = new TreeNode(postOrder[postOrder.length - 1]);

}*/
    /*public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void buildLeftTree(TreeNode positionNode, int position, int parentPosition, int[] inorder,
                               int[] postOrder) {
        Set<Integer> leftNodeSet = new HashSet<>();
        Set<Integer> rightNodeSet = new HashSet<>();
        for(int i = 0; i < position; i++) {
            leftNodeSet.add(inorder[i]);
        }

        for(int j = position + 1; j < parentPosition; j++) {
            rightNodeSet.add(inorder[j]);
        }
        boolean leftFound = false;
        boolean rightFound = false;

        for (int k = postOrder.length -1; k >= 0; k--) {
            if (leftNodeSet.isEmpty()) {
                leftFound = true;
                if (rightFound) {
                    break;
                }
            }
            if (rightNodeSet.isEmpty()) {
                rightFound = true;
                if (leftFound) {
                    break;
                }
            }
            if (!leftFound && leftNodeSet.contains(postOrder[k])) {
                TreeNode leftChild = new TreeNode(postOrder[k]);
                positionNode.left = leftChild;
                leftFound = true;
                buildLeftTree(leftChild, k, position, inorder, postOrder);
                buildRightTree(leftChild, k, position, inorder, postOrder);
                if (rightFound) {
                    break;
                }
            }

            if (!rightFound && rightNodeSet.contains(postOrder[k])) {
                TreeNode rightChild = new TreeNode(postOrder[k]);
                positionNode.right = rightChild;
                rightFound = true;
                buildLeftTree(rightChild, k, position, inorder, postOrder);
                buildRightTree(rightChild, k, position, inorder, postOrder);
                if (leftFound) {
                    break;
                }
            }
        }
    }

    private void buildRightTree(TreeNode positionNode,
                                int position,
                                int parentPosition,
                                int[] inorder,
                                int[] postOrder) {
        Set<Integer> leftNodeSet = new HashSet<>();
        Set<Integer> rightNodeSet = new HashSet<>();
        for(int i = parentPosition; i < position; i++) {
            leftNodeSet.add(inorder[i]);
        }

        for(int j = position + 1; j < inorder.length; j++) {
            rightNodeSet.add(inorder[j]);
        }

        boolean leftFound = false;
        boolean rightFound = false;
        TreeNode treeNode = new TreeNode(inorder[position]);
        for (int k = postOrder.length -1; k >= 0; k--) {
            if (leftNodeSet.isEmpty()) {
                leftFound = true;
                if (rightFound) {
                    break;
                }
            }
            if (rightNodeSet.isEmpty()) {
                rightFound = true;
                if (leftFound) {
                    break;
                }
            }

            if (!leftFound && leftNodeSet.contains(postOrder[k])) {
                TreeNode leftChild = new TreeNode(postOrder[k]);
                treeNode.left = leftChild;
                leftFound = true;
                buildLeftTree(leftChild, k, position, inorder, postOrder);
                buildRightTree(leftChild, k, position, inorder, postOrder);
                if (rightFound) {
                    break;
                }
            }

            if (!rightFound && rightNodeSet.contains(postOrder[k])) {
                TreeNode rightChild = new TreeNode(postOrder[k]);
                treeNode.right = rightChild;
                rightFound = true;
                buildLeftTree(rightChild, k, position, inorder, postOrder);
                buildRightTree(rightChild, k, position, inorder, postOrder);
                if (leftFound) {
                    break;
                }
            }
        }
    }*/

}
