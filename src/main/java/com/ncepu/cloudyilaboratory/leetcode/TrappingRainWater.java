package com.ncepu.cloudyilaboratory.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int length = height.length;
        int result = 0;
        int endIndex = length - 1, startIndex, midleIndex;

        while (true) {
            while (endIndex > 1 && height[endIndex] <= height[endIndex - 1]) {
                endIndex--;
            }
            if (endIndex == 1) {
                return result;
            }
            midleIndex = endIndex - 1;

            while (midleIndex >= 1 && height[midleIndex] >= height[midleIndex - 1]) {
                midleIndex--;
            }

            if (midleIndex == 0) {
                return result;
            }

            startIndex = midleIndex - 1;
            while (startIndex >= 1 && height[startIndex] <= height[startIndex - 1]) {
                startIndex--;
            }

            int s = startIndex, e = endIndex;
            if (height[s] > height[e]) {
                do {
                    s++;
                } while (height[s] >= height[e]);
                s -= 1;
            } else if (height[s] < height[e]) {
                do {
                    e--;
                } while (height[s] < height[e]);
                e += 1;
            }

            int tempResult = height[s] > height[e] ? height[e] : height[s];
            tempResult = tempResult * (e - s - 1);
            for (s++; s < e; s++) {
                tempResult -= height[s];
            }
            result += tempResult;
            endIndex = startIndex;
            if (endIndex < 1) {
                return result;
            }
        }
    }
}
