package com.ncepu.cloudyilaboratory.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortIntArray {

    public void mergeSort(int[] intArray) {
        recursiveMerge(intArray, 0, intArray.length - 1);
    }


    private void recursiveMerge(int[] intArray, int start, int end) {
        if (start >= end) {
            return;
        }

        int start1 = start, end1 = start1 + ((end - start) >> 1);
        int start2 = end1 + 1, end2 = end;

        recursiveMerge(intArray, start1, end1);
        recursiveMerge(intArray, start2, end2);

        int[] tempResult = new int[intArray.length];
        int low = start1;

        while (start1 <= end1 && start2 <= end2) {
            if (intArray[start1] <= intArray[start2]) {
                tempResult[low++] = intArray[start1++];
            } else {
                tempResult[low++] = intArray[start2++];
            }
        }

        while (start1 <= end1) {
            tempResult[low++] = intArray[start1++];
        }

        while(start2 <= end2) {
            tempResult[low++] = intArray[start2++];
        }

        for(; start <= end; start++) {
            intArray[start] = tempResult[start];
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {5,3,4,2,1};

        new MergeSortIntArray().mergeSort(intArray);

        for(int i : intArray) {
            System.out.print(i + ",");
        }



        List<Integer> integers = Arrays.asList(2, 3, 4, 1, 5);
        Collections.binarySearch(integers, 4);
        integers.toArray();
    }
}
