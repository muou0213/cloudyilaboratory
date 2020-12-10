package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumV2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);


        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }

            for (int j = i + 1, k = nums.length - 1; j < k;) {
                // 去重
                if (nums[j] == nums[j -1] && j != i +1) {
                    j++;
                    continue;
                }
                if (k != nums.length -1 &&  nums[k] == nums[k+1] ) {
                    k--;
                    continue;
                }

                int sumResult = nums[i] + nums[j] + nums[k];
                if (sumResult == 0) {
                    List<Integer> oneResult = new ArrayList<>(3);
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j]);
                    oneResult.add(nums[k]);
                    result.add(oneResult);

                    k--;
                    j++;
                } else if (sumResult > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
//        int[] nums = new int[] {0, 0, 0};
//        int[] nums = new int[] {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ThreeSumV2().threeSum(nums);
        System.out.println(lists);
    }
}
