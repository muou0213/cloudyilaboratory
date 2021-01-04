package com.ncepu.cloudyilaboratory.interview;

public class ABArrayMerge {
    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;
        A[3] = 6;

        int[] B = new int[]{2,4};

        ABArrayMerge s = new ABArrayMerge();
        s.merge(A, 4, B, 2);
        for (int i = 0; i < 4 + 2; i++) {
            System.out.println(A[i]);
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[A.length];

        int i = 0, j = 0, k=0;

        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = B[j++];
            }
        }

        while (i < m) {
            temp[k++] = A[i++];
        }

        while(j < n) {
            temp[k++] = B[j++];
        }

        for (int z = 0; z < m + n; z++) {
            A[z] = temp[z];
        }
    }
}
