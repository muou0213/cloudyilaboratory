package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:huangyunyi
 **/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);
        generateOneRow(pascalTriangle, 2, numRows);
        return pascalTriangle;
    }

    public void generateOneRow(List<List<Integer>> pascalTriangle, int rowNumber, int rowNumLimit) {
        if (rowNumber > rowNumLimit) {
            return;
        }
        List<Integer> previousRow = pascalTriangle.get(rowNumber - 2);
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < previousRow.size(); i++) {
            if (i == 0) {
                row.add(1);
                continue;
            }
            Integer t = previousRow.get(i-1) + previousRow.get(i);
            row.add(t);
        }
        row.add(1);
        pascalTriangle.add(row);
        generateOneRow(pascalTriangle, rowNumber + 1, rowNumLimit);

    }

    public static void main(String[] args) {
        new PascalTriangle().generate(5);
    }
}
