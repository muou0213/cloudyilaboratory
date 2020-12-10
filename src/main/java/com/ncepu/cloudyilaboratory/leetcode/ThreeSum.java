package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> numPositionMap = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            /*Integer count = numPositionMap.get(nums[i]);
            if(count == null) {
                numPositionMap.put(nums[i], 1);
            } else {
                numPositionMap.put(nums[i], count + 1);
            }*/
            numPositionMap.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }

//            numPositionMap.put(nums[i], numPositionMap.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j -1]) {
                    continue;
                }
                /*for (int k = j + 1;k < nums.length;k++) {
                    if (nums[k] == (0 - nums[i] - nums[j])) {
                        List<Integer> oneResult = new ArrayList(3);
                        oneResult.add(nums[i]);
                        oneResult.add(nums[j]);
                        oneResult.add(nums[k]);
                        result.add(oneResult);
                    }
                }*/
                /*numPositionMap.put(nums[j], numPositionMap.get(nums[j]) - 1);
                Integer count = numPositionMap.get(0 - nums[i] - nums[j]);
                if (count != null && count > 0) {
                    List<Integer> oneResult = new ArrayList(3);
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j]);
                    oneResult.add(0 - nums[i] - nums[j]);
                    result.add(oneResult);
                }*/
                Integer index = numPositionMap.get(0 - nums[i] - nums[j]);
                if (index != null &&  index >j) {
                    List<Integer> oneResult = new ArrayList(3);
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j]);
                    oneResult.add(0 - nums[i] - nums[j]);
                    result.add(oneResult);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
//        int[] nums = new int[] {0,0,0,0};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        System.out.println(lists);
    }
}
