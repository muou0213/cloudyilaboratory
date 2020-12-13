package com.ncepu.cloudyilaboratory.leetcode;

public class BinaryArrayClockwisePrinter {

    private int[][] binaryArray;

    public void print() {
        int xStartIndex = 0, yStartIndex = xStartIndex;
        int xLength = binaryArray[0].length, yLength = binaryArray.length;

        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; ;i++) {
            xStartIndex += i;
            yStartIndex += i;
            int xEndIndex = xLength - 1 - xStartIndex;
            int yEndIndex = yLength - 1 - yStartIndex;

            if (xStartIndex > xEndIndex && yStartIndex > yEndIndex) {
                break;
            }

            String firstQC = printFirstQC(xStartIndex, xEndIndex, yStartIndex);
            resultSb.append(firstQC);
            String secondQC = printSecondQC(yStartIndex, yEndIndex, xEndIndex);
            resultSb.append(secondQC);
            String thirdQC = printThirdQC(xStartIndex, xEndIndex, yEndIndex);
            resultSb.append(thirdQC);
            String fourthQC = printFourthQC(yStartIndex, yEndIndex, xStartIndex);
            resultSb.append(fourthQC);
        }

        System.out.println(resultSb.toString());
    }

    private String printFirstQC(int xStartIndex,
                              int xEndIndex,
                                int yIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = xStartIndex; i <= xEndIndex; i++) {
            sb.append(binaryArray[yIndex][i]).append(",");
        }
        return sb.toString();
    }

    private String printSecondQC(int yStartIndex, int yEndIndex, int xIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = yStartIndex + 1; i <= yEndIndex; i++) {
            sb.append(binaryArray[i][xIndex]).append(",");
        }
        return sb.toString();
    }

    private String printThirdQC(int xStartIndex, int xEndIndex, int yIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = xEndIndex - 1;  i >= xStartIndex; i--) {
            sb.append(binaryArray[yIndex][i]).append(",");
        }
        return sb.toString();
    }

    private String printFourthQC(int yStartIndex, int yEndIndex, int xIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = yEndIndex - 1;  i > yStartIndex; i--) {
            sb.append(binaryArray[i][xIndex]).append(",");
        }
        return sb.toString();
    }

    public void initBinaryArray() {
        binaryArray = new int[4][4];

        binaryArray[0] = new int[] {1, 2, 3, 4};
        binaryArray[1] = new int[] {5, 6, 7, 8};
        binaryArray[2] = new int[] {9, 10, 11, 12};
        binaryArray[3] = new int[] {13, 14, 15, 16};
    }

    public static void main(String[] args) {
        BinaryArrayClockwisePrinter printer = new BinaryArrayClockwisePrinter();

        printer.initBinaryArray();
        printer.print();
    }

}
