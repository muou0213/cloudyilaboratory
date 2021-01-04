package com.ncepu.cloudyilaboratory.interview;

import java.util.ArrayList;
import java.util.List;

public class FiveThreeOneNumber {
    public static void main(String[] args) {
        FiveThreeOneNumber test1 = new FiveThreeOneNumber();
        test1.getEleven(11);
    }

    public void getEleven(int x) {
        int numberOf5 = 0;
        while (x - 5 > 0) {
            numberOf5++;
            x = x -5;
        }

        int numberOf3 = 0;
        while (x - 3 > 0) {
            numberOf3++;
            x = x -3;
        }

        int numberOf1 = x;

        System.out.println("5的个数: " + numberOf5
                + ",3的个数: " + numberOf3 + ",1的个数: " + numberOf1);
    }

    public void getLongestSubString(String s) {

    }

    public void binarySearch() {
        List<Integer> searchArray = new ArrayList<>();
        searchArray.add(1);
        searchArray.add(3);
        searchArray.add(5);
        searchArray.add(7);
        int toFind = 5;

        int result = -1;

        int low = 0, high = searchArray.size() - 1, mid = (low + high) >> 1;

        while (true) {
            if (low > high) {
                break;
            }
            if (toFind > searchArray.get(mid)) {
                low = mid + 1;
            } else if (toFind < searchArray.get(mid)) {
                high = mid - 1;
            } else {
                result = mid;
                break;
            }
            mid = (low + high) >> 1;
        }

        System.out.println(result);
    }
}
