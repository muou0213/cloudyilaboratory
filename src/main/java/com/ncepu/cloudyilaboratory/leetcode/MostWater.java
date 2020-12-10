package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class MostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i< height.length; i++) {
            for(int j = i+1; j <height.length; j++ ){
                int value = height[i] > height[j] ? height[j] * (j - i) : height[i] * (j - i);
                if (max < value) {
                    max = value;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l<r){
            max = Math.max(Math.min(height[l], height[r])* (r-l), max);
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};

      /*  ArrayList[] listArray = new
        int i = new MostWater().maxArea2(height);
        System.out.println(i);
        Map<Integer, Integer> numMap = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = numMap.entrySet();
        entries.toArray(new Map.Entry<Integer, Integer>[0]);*/
    }
}
