package com.ncepu.cloudyilaboratory.binarysearchtree;

public class AVLTreeV2 {
    private AVLTreeNodeV2 treeRoot;
    
    public AVLTreeNodeV2 insert(AVLTreeNodeV2 node, int value) {
        if (node == null) {
            node = new AVLTreeNodeV2(value);
            return node;
        }
        
        if (value < node.getValue()) {
            AVLTreeNodeV2 insertNode = insert(node.getLeftChild(), value);
            node.setLeftChild(insertNode);
        } else {
            AVLTreeNodeV2 insertNode = insert(node.getRightChild(), value);
            node.setRightChild(insertNode);
        }

        node.setHeight(subTreeHeight(node) + 1);

        // 判断树是否平衡
        // ll
        if (balance(node) > 1 && value < node.getLeftChild().getValue()) {
            return rightRotate(node);
        }
        // lr
        else if (balance(node) > 1 && value >= node.getLeftChild().getValue()) {
            node.setLeftChild(leftRotate(node.getLeftChild()));
            return rightRotate(node);
        }
        // rr
        else if (balance(node) < -1 && value >= node.getRightChild().getValue()) {
           return leftRotate(node);
        }
        // rl
        else if (balance(node) < -1 && value < node.getRightChild().getValue()) {
            node.setRightChild(rightRotate(node.getRightChild()));
            return leftRotate(node);
        }
        // 已经是平衡树
        else {
            return node;
        }
    }

    public int balance(AVLTreeNodeV2 node) {
        return height(node.getLeftChild()) -  height(node.getRightChild());
    }

    public int height(AVLTreeNodeV2 node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private AVLTreeNodeV2 leftRotate(AVLTreeNodeV2 node) {
        AVLTreeNodeV2 rightNode = node.getRightChild();

        node.setRightChild(rightNode.getLeftChild());
        rightNode.setLeftChild(node);

        node.setHeight(subTreeHeight(node) + 1);
        rightNode.setHeight(subTreeHeight(rightNode) + 1);
        return rightNode;
    }

    private AVLTreeNodeV2 rightRotate(AVLTreeNodeV2 node) {
        AVLTreeNodeV2 leftNode = node.getLeftChild();

        node.setLeftChild(leftNode.getRightChild());
        leftNode.setRightChild(node);

        node.setHeight(subTreeHeight(node) + 1);
        leftNode.setHeight(subTreeHeight(leftNode) + 1);

        return leftNode;
    }

    private int subTreeHeight(AVLTreeNodeV2 node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public static void main(String[] args) {
        AVLTreeV2 tree = new AVLTreeV2();
        tree.treeRoot = tree.insert(tree.treeRoot, 10);
        tree.treeRoot = tree.insert(tree.treeRoot, 20);
        tree.treeRoot = tree.insert(tree.treeRoot, 5);
        tree.treeRoot = tree.insert(tree.treeRoot, 2);
        tree.treeRoot = tree.insert(tree.treeRoot, 4);
        tree.treeRoot = tree.insert(tree.treeRoot, 3);
        //        tree.printTree();
        //        tree.printTreeTest();
        BTreePrinter.printNode(tree.treeRoot);
    }
}

class AVLTreeNodeV2 implements AVLTreeNodeInterface {
    private AVLTreeNodeV2 rightChild;
    private AVLTreeNodeV2 leftChild;
    private Integer height;
    private Integer value;
    
    public AVLTreeNodeV2() {
        
    }
    
    public AVLTreeNodeV2(int value) {
        this.value = value;
        this.height = 1;
    }

    public AVLTreeNodeV2 getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLTreeNodeV2 rightChild) {
        this.rightChild = rightChild;
    }

    public AVLTreeNodeV2 getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLTreeNodeV2 leftChild) {
        this.leftChild = leftChild;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}


