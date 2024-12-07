package com.main.example.codingtest;

public class MergeSortClass {

    public void mergeSortCall() {
        int[] arr = {10, 1, 29,30,2,30,4,5};
        int l = 0;
        int r = arr.length-1;
        mergeSort(arr, l, r);

    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int mid = (l+r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, mid, l, r);
        }
    }

    public static void merge(int[] arr, int m, int l , int r) {
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for(int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
    }
}
