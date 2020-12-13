package com.ncepu.cloudyilaboratory.leetcode;

public class SearchInRotatedOrderedArray {

    private Integer[] array;
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
    public int search(int value) {
        int low = 0, high = array.length - 1;
        int mid = (low + high) >> 1;

        while (true) {
            if (value == array[mid]) {
                return mid;
            }
            boolean valueGreaterThenMid = value > array[mid];
            if (array[low] < array[mid]) {
                if (valueGreaterThenMid) {
                    low = mid + 1;
                } else {
                    if (value < array[low]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                if (valueGreaterThenMid) {
                    if (value < array[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    high = mid - 1;
                }
            }
            if (low > high) {
                break;
            }
            mid = (low + high) >> 1;
        }
        return -1;
    }

    public void initArray() {
        array = new Integer[] {4,5,6,7,0,1,2};
    }

    public static void main(String[] args) {
        SearchInRotatedOrderedArray search = new SearchInRotatedOrderedArray();
        search.initArray();

        int index1 = search.search(5);
        System.out.println("index of 5 is " + index1);

        int index2 = search.search(3);
        System.out.println("index of 3 is " + index2);
    }
}
