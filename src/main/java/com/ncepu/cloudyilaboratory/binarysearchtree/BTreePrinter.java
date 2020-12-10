package com.ncepu.cloudyilaboratory.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

    public static void printNode(AVLTreeNodeInterface root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    // 每次打印都是打印一行及其下面所有的斜杠和反斜杠行
    // 其中涉及到的结论有
    // 1.数字行每行开头的空格的计算方式
    // 2.数字行节点之间空格的计算方式
    // 3.斜杠行开头空格的计算方式
    // 4.左斜杠和右斜杠之间空格的计算方式，这是个等差数列
    // 5.上一个节点的右斜杠和下一个节点的左斜杠之间的空格的计算方式，这也是个等差数列，公差为-2

    // 总的来讲，有两种打印方式，一种是从上到下，但是需要确定各个空格的计算方式
    // 一种是从下到上，需要借助数组下标计算来进行打印
    private static  void printNodeInternal(List<AVLTreeNodeInterface> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<AVLTreeNodeInterface> newNodes = new ArrayList<>();
        for (AVLTreeNodeInterface node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeftChild());
                newNodes.add(node.getRightChild());
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
                if (nodes.get(j).getLeftChild() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                // 等差数列通项公式为2n-1
                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightChild() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);
                // 等差数列，通项公式为endgeLines + endgeLines - i + firstSpaces - i
                // 也就是循环的结束行和开始行之和
                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends AVLTreeNodeInterface> int maxLevel(T node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.getLeftChild()), BTreePrinter.maxLevel(node.getRightChild())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
