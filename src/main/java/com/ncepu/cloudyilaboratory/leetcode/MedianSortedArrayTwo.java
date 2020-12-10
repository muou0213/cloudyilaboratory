package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class MedianSortedArrayTwo {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO 有一个数组为空的情况
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return n % 2 == 0? Double.valueOf(nums2[n/2 - 1] + nums2[n/2])/2 : nums2[n/2];
        }
        if (n ==0) {
            return m % 2 == 0 ? Double.valueOf(nums1[m/2 -1] + nums1[m/2])/2 : nums1[m/2];
        }
        // 对数组一进行折半查找
        int i = (m + n)/2 + 1;
        int j = i / 2;
        int k = i - j;
        int rightEnd = m;
        int leftEnd = 0;
        while (true) {
            // 右移
            if (j < 0 || k >= n + 1 || (k >= 1 && j < m && nums2[k-1] > nums1[j])) {
                leftEnd = j;
                j = j == m - 1 ? m : j + (rightEnd -j)/2;
                k = i -j;
                continue;
            }
            // 左移
            if (k < 0 || j >= m + 1 || (j >=1 && k < n && nums1[j - 1] > nums2[k])) {
                rightEnd = j;
                j = leftEnd + (j - leftEnd) / 2;
                k = i-j;
                continue;
            }
            break;
        }


        if ((m + n) % 2 != 0) {
            if (j == 0) {
                return nums2[k-1];
            }
            if (k == 0) {
                return nums1[j-1];
            }
            return nums1[j-1] > nums2[k-1] ? nums1[j-1] : nums2[k-1];
        } else {
            if (k == 0 || (j >= 2 && nums1[j-2] >= nums2[k-1])) {
                return Double.valueOf(nums1[j-1] + nums1[j-2]) / 2;
            } else if(j == 0 || (k >=2 && nums2[k-2] >= nums1[j-1])) {
                return Double.valueOf(nums2[k-2] + nums2[k-1]) / 2;
            } else {
                return Double.valueOf(nums1[j-1] + nums2[k-1]) / 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] nums2 = new int[] {0,6};

        double medianSortedArrays = new MedianSortedArrayTwo().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
