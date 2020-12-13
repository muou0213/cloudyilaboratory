package com.ncepu.cloudyilaboratory.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryArrayClockwisePrinterV2 {

    private int[][] binaryArray;
    private List<Integer> resultList = new LinkedList<>();

    public void print() {
        int direction = 0;
        int xLength = binaryArray[0].length, yLength = binaryArray.length;


        for (int i = 0; ; i++) {
            int xStartIndex = 0 + i, yStartIndex = 0 + i;
            int xEndIndex = xLength - 1 - i, yEndIndex = yLength - 1 - i;

            if (xStartIndex > xEndIndex && yStartIndex > yEndIndex) {
                break;
            }

            int xIndex = xStartIndex, yIndex = yStartIndex;

            while (true) {
                resultList.add(binaryArray[yIndex][xIndex]);

                switch (direction) {
                    case 0:
                        xIndex++;
                        if (xIndex >= xEndIndex) {
                            direction = 1;
                        }
                        break;
                    case 1:
                        yIndex++;
                        if (yIndex >= yEndIndex) {
                            direction = 2;
                        }
                        break;
                    case 2:
                        xIndex--;
                        if (xIndex <= xStartIndex) {
                            direction = 3;
                        }
                        break;
                    case 3:
                        yIndex--;
                        if (yIndex <= yStartIndex) {
                            direction = 0;
                        }
                        break;
                }
                if (xIndex == xStartIndex && yIndex == yStartIndex) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer integer : resultList) {
            sb.append(integer).append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        System.out.println(substring);
    }

    public void initBinaryArray() {
        binaryArray = new int[4][4];

        binaryArray[0] = new int[] {1, 2, 3, 4};
        binaryArray[1] = new int[] {5, 6, 7, 8};
        binaryArray[2] = new int[] {9, 10, 11, 12};
        binaryArray[3] = new int[] {13, 14, 15, 16};
    }

    public static void main(String[] args) {
        BinaryArrayClockwisePrinterV2 printer = new BinaryArrayClockwisePrinterV2();

        printer.initBinaryArray();
        printer.print();
    }

}
