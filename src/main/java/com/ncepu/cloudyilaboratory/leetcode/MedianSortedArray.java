package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class MedianSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int t = 0;

        for (int i = 0; i < nums1.length; i++,t++) {
            mergedArray[t] = nums1[i];
        }

        for (int j = 0; j < nums2.length; j++,t++) {
            mergedArray[t] = nums2[j];
        }

        boolean isEven = mergedArray.length % 2 == 0;
        int middleIndex = mergedArray.length / 2;
        if (middleIndex == 0) {
            return mergedArray[0];
        }

        if (isEven) {
            if (middleIndex == 1) {
                return (mergedArray[0] + mergedArray[1]) / 2;
            }

        } else {

        }
        return 0;
    }

    private void leftMaxHeap(int[] arr, int parent, int length) {
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;

                // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
                if (rChild < length && arr[lChild] < arr[rChild]) {
                    lChild++;
                }

                // 如果父结点的值已经大于孩子结点的值，则直接结束
                /*if (temp >= arr[lChild]) {
                    break;
                }*/

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
    }


    private void adjustHeap(int[] arr, int parent, int length, HeapType type) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            if (type == HeapType.MAX_HEAP) {
                // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
                if (rChild < length && arr[lChild] < arr[rChild]) {
                    lChild++;
                }

                // 如果父结点的值已经大于孩子结点的值，则直接结束
                if (temp >= arr[lChild]) {
                    break;
                }
            } else {
                // 如果有右孩子结点，并且右孩子结点的值小于左孩子结点，则选取右孩子结点
                if (rChild < length && arr[lChild] > arr[rChild]) {
                    lChild++;
                }

                // 如果父结点的值已经小于右孩子结点的值，则直接结束
                if (temp <= arr[lChild]) {
                    break;
                }
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
    }

    private enum HeapType {
        MIN_HEAP,
        MAX_HEAP
    }
}
