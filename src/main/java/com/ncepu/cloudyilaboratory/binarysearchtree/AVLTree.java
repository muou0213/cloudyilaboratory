package com.ncepu.cloudyilaboratory.binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AVLTree {
    private AVLTreeNode treeRoot;

    public void insertValue(int value) {
        if (treeRoot == null) {
            treeRoot = new AVLTreeNode(value);
            return;
        }

        AVLTreeNode treeNode = treeRoot;
        AVLTreeNode notBlancedTreeNode = null;

        if(treeNode.getLeftTreeHeight() != treeNode.getRightTreeHeight()) {
            notBlancedTreeNode = treeNode;
        }

        boolean firstDirectionLeft = true;
        boolean secondDirectionLeft = true;

        do {
            // 向右走
            if (value >= treeNode.getValue()) {
                if (treeNode.getRightTreeHeight() != treeNode.getLeftTreeHeight()) {
                    notBlancedTreeNode = treeNode;
                    firstDirectionLeft = false;
                }
                if (notBlancedTreeNode != null && treeNode.getParent() != null && treeNode.getParent() ==
                        notBlancedTreeNode) {
                    secondDirectionLeft = false;
                }
                if (treeNode.getRightChild() == null) {
                    break;
                }
                treeNode = treeNode.getRightChild();
            } else { // 向左走
                if (treeNode.getRightTreeHeight() != treeNode.getLeftTreeHeight()) {
                    notBlancedTreeNode = treeNode;
                    firstDirectionLeft = true;
                }
                if (notBlancedTreeNode != null && treeNode.getParent() != null && treeNode.getParent() ==
                        notBlancedTreeNode) {
                    secondDirectionLeft = true;
                }
                if (treeNode.getLeftChild() == null) {
                    break;
                }
                treeNode = treeNode.getLeftChild();
            }
        } while (true);
        /*while (value >= treeNode.getValue() && treeNode.getRightChild() != null) {
            if (treeNode.getRightTreeHeight() != treeNode.getLeftTreeHeight()) {
                notBlancedTreeNode = treeNode;
                firstDirectionLeft = false;
            }
            if (notBlancedTreeNode != null && treeNode.getParent() != null && treeNode.getParent() ==
                    notBlancedTreeNode) {
                secondDirectionLeft = false;
            }
            treeNode = treeNode.getRightChild();
        }
        while (value < treeNode.getValue() && treeNode.getLeftChild() != null) {
            if (treeNode.getRightTreeHeight() != treeNode.getLeftTreeHeight()) {
                notBlancedTreeNode = treeNode;
                firstDirectionLeft = true;
            }
            if (notBlancedTreeNode != null && treeNode.getParent() != null && treeNode.getParent() ==
                    notBlancedTreeNode) {
                secondDirectionLeft = true;
            }
            treeNode = treeNode.getLeftChild();
        }*/
        boolean addLevel = treeNode.getLeftChild() == null && treeNode.getRightChild() == null;

        AVLTreeNode toAdd = new AVLTreeNode(value);
        if (value < treeNode.getValue()) {
            treeNode.setLeftChild(toAdd);
            treeNode.increaseLeftTreeHeight();
            toAdd.setParent(treeNode);
        } else {
            treeNode.setRightChild(toAdd);
            treeNode.increaseRightTreeHeight();
            toAdd.setParent(treeNode);
        }

        if (addLevel){
            updateNodeHeight(treeNode);
        }

        // 不满足平衡二叉树的条件
        if (treeNode.getParent() != null &&
                notBlancedTreeNode != null &&
                addLevel &&
                ((notBlancedTreeNode.getLeftTreeHeight() > notBlancedTreeNode.getRightTreeHeight()
                          && firstDirectionLeft) ||
                         (notBlancedTreeNode.getLeftTreeHeight() < notBlancedTreeNode.getRightTreeHeight() &&
                                  !firstDirectionLeft))
                ) {
            if (firstDirectionLeft && secondDirectionLeft) {
                AVLTreeNode leftChild = notBlancedTreeNode.getLeftChild();
                // handleLL();
                AVLTreeNode node = handleLL(leftChild);
                if (treeRoot == notBlancedTreeNode) {
                    treeRoot = node;
                }
            } else if (!firstDirectionLeft && !secondDirectionLeft) {
                AVLTreeNode rightChild = notBlancedTreeNode.getRightChild();
                // handleRR();
                AVLTreeNode node = handleRR(rightChild);
                if (treeRoot == notBlancedTreeNode) {
                    treeRoot = node;
                }
            } else if (firstDirectionLeft && !secondDirectionLeft) {
                AVLTreeNode leftChild = notBlancedTreeNode.getLeftChild();
                // handleLR
                handleLR(leftChild);
            } else {
                AVLTreeNode rightChild = notBlancedTreeNode.getRightChild();
                // handleRL
                handleRL(rightChild);
            }
        }
    }

    // 右旋，左子树不变
    private AVLTreeNode handleLL(AVLTreeNode treeNode) {
        AVLTreeNode parentNode = treeNode.getParent();
        parentNode.setLeftChild(null);
        parentNode.setLeftTreeHeight(0);

        setNewParentNode(treeNode, parentNode);
        if (treeNode.getRightChild() != null) {
            parentNode.setLeftChild(treeNode.getRightChild());
            parentNode.setLeftTreeHeight(1);
            treeNode.getRightChild().setParent(parentNode);
        }

        treeNode.setRightChild(parentNode);
        parentNode.setParent(treeNode);
        treeNode.setRightTreeHeight(Math.max(parentNode.getLeftTreeHeight(), parentNode.getLeftTreeHeight()) + 1);

        // treeNode的parent左、右子树高度不变
        return treeNode;
    }

    private AVLTreeNode handleRR(AVLTreeNode treeNode) {
        AVLTreeNode parentNode = treeNode.getParent();
        parentNode.setRightChild(null);
        parentNode.setRightTreeHeight(0);

        setNewParentNode(treeNode, parentNode);

        if (treeNode.getLeftChild() != null) {
            parentNode.setRightChild(treeNode.getLeftChild());
            parentNode.setRightTreeHeight(1);
            treeNode.getLeftChild().setParent(parentNode);
        }

        treeNode.setLeftChild(parentNode);
        parentNode.setParent(treeNode);
        treeNode.setLeftTreeHeight(Math.max(parentNode.getLeftTreeHeight(), parentNode.getLeftTreeHeight()) + 1);

        return treeNode;
    }

    private void handleLR(AVLTreeNode treeNode) {
        AVLTreeNode rightChild = treeNode.getRightChild();
        if (rightChild == null) {
            throw new IllegalArgumentException("right child is null");
        }
        treeNode.setRightChild(null);
        treeNode.setRightTreeHeight(0);

        AVLTreeNode parentNode = treeNode.getParent();
        rightChild.setParent(parentNode);
        parentNode.setLeftChild(rightChild);

        if (rightChild.getLeftChild() != null) {
            AVLTreeNode rightChildLeftChild  = rightChild.getLeftChild();

            treeNode.setRightChild(rightChildLeftChild);
            rightChildLeftChild.setParent(treeNode);
            treeNode.setRightTreeHeight(Math.max(rightChildLeftChild.getLeftTreeHeight(), rightChildLeftChild
                    .getRightTreeHeight()) + 1);
        }
        rightChild.setLeftChild(treeNode);
        treeNode.setParent(rightChild);

        rightChild.setLeftTreeHeight(Math.max(treeNode.getLeftTreeHeight(), treeNode.getRightTreeHeight()) + 1);
        parentNode.setLeftTreeHeight(Math.max(rightChild.getLeftTreeHeight(), rightChild.getRightTreeHeight()) + 1);
        handleLL(rightChild);
    }

    private void handleRL(AVLTreeNode treeNode) {
        AVLTreeNode leftChild = treeNode.getLeftChild();
        if (leftChild == null) {
            throw new IllegalArgumentException("left child is null");
        }
        treeNode.setLeftChild(null);
        treeNode.setLeftTreeHeight(0);

        AVLTreeNode parentNode = treeNode.getParent();
        leftChild.setParent(parentNode);
        parentNode.setRightChild(leftChild);

        if (leftChild.getRightChild() != null) {
            AVLTreeNode leftChildRightChild = leftChild.getRightChild();

            treeNode.setLeftChild(leftChildRightChild);
            leftChildRightChild.setParent(treeNode);
            treeNode.setLeftTreeHeight(Math.max(leftChildRightChild.getLeftTreeHeight(), leftChildRightChild
                    .getRightTreeHeight()) + 1);
        }
        leftChild.setRightChild(treeNode);
        treeNode.setParent(leftChild);
        leftChild.setRightTreeHeight(Math.max(treeNode.getLeftTreeHeight(), treeNode.getRightTreeHeight()) + 1);

        parentNode.setRightTreeHeight(Math.max(leftChild.getLeftTreeHeight(), leftChild.getRightTreeHeight()) + 1);
        handleRR(leftChild);
    }

    private void updateNodeHeight(AVLTreeNode node) {
        AVLTreeNode parent = node.getParent();
        while(parent != null) {
            if (parent.getRightChild() == node) {
                parent.setRightTreeHeight(Math.max(node.getLeftTreeHeight(), node.getRightTreeHeight()) + 1);
            } else {
                parent.setLeftTreeHeight(Math.max(node.getLeftTreeHeight(), node.getRightTreeHeight()) + 1);
            }
            node = parent;
            parent = node.getParent();
        }
    }

    private void setNewParentNode(AVLTreeNode treeNode, AVLTreeNode parentNode) {
//        if (parentNode.getParent() != null) {
//            if (parentNode.getParent().getLeftChild() == parentNode) {
//                parentNode.getParent().setLeftChild(treeNode);
//            } else {
//                parentNode.getParent().setRightChild(treeNode);
//
//            }
//            treeNode.setParent(parentNode.getParent());
//        }
    }

    // 这个打印算法实现是想从最底层开始打印起，逐层向上打印
    // 但是其实层数越高斜杠和上层节点之间的空格数就会发生变化
    // 在网站上打印树是通过斜杠角度来调整
    // 从底层利用数组打印上层是个很巧妙的想法
    // 但是这个要求树的实现中有parent这个指针
    public void printTree() {
        if (treeRoot == null) {
            System.out.println("empty tree");
        }

        List<List<AVLTreeNode>> nodesInLevels = new ArrayList<>();

        List<AVLTreeNode> nodesInOneLevel = new LinkedList<>();
        nodesInOneLevel.add(treeRoot);
        nodesInLevels.add(nodesInOneLevel);
        while(true) {
            // 取出上层的所有节点，依次将他们的子节点添加到下一层的list中
            boolean endWhile = true;
            List<AVLTreeNode> nodesInNextLevel = new LinkedList<>();
            Iterator<AVLTreeNode> iterator = nodesInOneLevel.iterator();
            while(iterator.hasNext()) {
                AVLTreeNode nodeInOneLevel = iterator.next();
                if (nodeInOneLevel.getLeftChild() != null) {
                    endWhile = false;
                    nodesInNextLevel.add(nodeInOneLevel.getLeftChild());
                }
                if (nodeInOneLevel.getRightChild() != null) {
                    endWhile = false;
                    nodesInNextLevel.add(nodeInOneLevel.getRightChild());
                }
            }
            if (endWhile) {
                break;
            }
            nodesInLevels.add(nodesInNextLevel);
            nodesInOneLevel = nodesInNextLevel;
        }

        int treeHeight = Math.max(treeRoot.getLeftTreeHeight(), treeRoot.getRightTreeHeight()) + 1;
        int bottomLevelCount = 1 << (treeHeight - 1);

        boolean[][] treePrintArray = new boolean[treeHeight][bottomLevelCount];
        int levelCount = nodesInLevels.size();

        // 暂时不考虑只有根节点的情况
        // 打印最后一层
        int leftChildIndex = 0;
        int rightChildIndex = 4;
        nodesInOneLevel = nodesInLevels.get(levelCount - 1);
        Iterator<AVLTreeNode> iterator = nodesInOneLevel.iterator();
        while(iterator.hasNext()) {
            AVLTreeNode node = iterator.next();
            if (node.getParent() != null) {
                AVLTreeNode parentNode = node.getParent();
                if (node == parentNode.getLeftChild()) {
                    treePrintArray[treeHeight - 1][leftChildIndex] = true;
                } else {
                    treePrintArray[treeHeight - 1][rightChildIndex] = true;
                }
            } else {
                break;
            }
            leftChildIndex+=6;
            rightChildIndex+=6;
        }

        List<String> lines = new LinkedList<>();
        // 遍历所有层，每一层都用来打印上面两层
        for (int i = levelCount - 1; i >= 0; i--) {
            nodesInOneLevel = nodesInLevels.get(i);

            iterator = nodesInOneLevel.iterator();
            int j = 0;
            while (iterator.hasNext()) {
                AVLTreeNode node = iterator.next();
                boolean[] oneLevelPrintArray = treePrintArray[i];
                for (; j < oneLevelPrintArray.length; j++) {
                    if (oneLevelPrintArray[j] == true) {
                        if (node.getParent() != null) {
                            AVLTreeNode parentNode = node.getParent();
                            if (node == parentNode.getLeftChild()) {
                                treePrintArray[i - 1][j + 1] = true;
                            } else {
                                treePrintArray[i - 1][j - 1] = true;

                            }
                        }
                    }
                }
            }
        }

    }

    public void printTreeTest() {
        PrintTreeStringBuilder sb = new PrintTreeStringBuilder();
        sb.addSpaceCharacter(5).append('4').append("\r\n");
        sb.addSpaceCharacter(3).append('/').addSpaceCharacter(3).append('\\').append("\r\n");
        sb.addSpaceCharacter(2).append('2').addSpaceCharacter(5).append("10").append("\r\n");
        sb.append(' ').append('/').append(' ').append('\\').addSpaceCharacter(3).append('/').append(' ').append('\\')
                .append
                ("\r\n");
        sb.append('1').addSpaceCharacter(3).append('3').append(' ').append('5').addSpaceCharacter(3).append("20")
                .append("\r\n");

        System.out.println(sb.toString());
    }



    private class PrintTreeStringBuilder {
        private final StringBuilder sb = new StringBuilder();

        public PrintTreeStringBuilder append(char c) {
            sb.append(c);
            return this;
        }

        public PrintTreeStringBuilder append(String s) {
            sb.append(s);
            return this;
        }

        public String toString() {
            return sb.toString();
        }

        public PrintTreeStringBuilder addSpaceCharacter(Integer count) {
            if (count <= 0) {
                return this;
            }

            while(count > 0) {
                sb.append(" ");
                count--;
            }
            return this;
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insertValue(10);
        tree.insertValue(20);
        tree.insertValue(5);
        tree.insertValue(2);
        tree.insertValue(4);
        tree.insertValue(3);
//        tree.printTree();
//        tree.printTreeTest();
        BTreePrinter.printNode(tree.treeRoot);
    }
}

class AVLTreeNode implements AVLTreeNodeInterface {
    private AVLTreeNode leftChild;
    private AVLTreeNode rightChild;
    private AVLTreeNode parent;
    private Integer value;
    private Integer leftTreeHeight;
    private Integer rightTreeHeight;

    public AVLTreeNode() {}

    public AVLTreeNode(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
        leftTreeHeight = 0;
        rightTreeHeight = 0;
    }

    public AVLTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLTreeNode rightChild) {
        this.rightChild = rightChild;
    }


    public AVLTreeNode getParent() {
        return parent;
    }

    public void setParent(AVLTreeNode parent) {
        this.parent = parent;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Integer getLeftTreeHeight() {
        return leftTreeHeight;
    }

    public void setLeftTreeHeight(Integer leftTreeHeight) {
        this.leftTreeHeight = leftTreeHeight;
    }

    public Integer getRightTreeHeight() {
        return rightTreeHeight;
    }

    public void setRightTreeHeight(Integer rightTreeHeight) {
        this.rightTreeHeight = rightTreeHeight;
    }

    public void increaseLeftTreeHeight() {
        this.leftTreeHeight++;
    }

    public void increaseRightTreeHeight() {
        this.rightTreeHeight++;
    }
}

