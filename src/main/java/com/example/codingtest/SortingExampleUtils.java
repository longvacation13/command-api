package com.example.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class SortingExampleUtils {

    /**
     * 시간복잡도 n^2
     *
     */
    public void 선택정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};

        int minIndex = 0;
        for(int i = 0; i <  arr.length ; i++) {
            minIndex = i;       // 비교하기위한 값 -> 이 값을 최소값으로 잡고 이값보다 작은값을 minIndex로 교체한다.
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public void 버블정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};

        // 1. for : 순환 횟수
        // 1번째 순환 : 현재 상태에서 가장 큰 값이 오른쪽으로 밀림
        // 2번째 순환 : 현재 상태에서 가장 큰 값이 오른쪽 - 1 번째로 밀림
        // ...
        // 5번째 순환 : 1번째로 밀림
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void 삽입정렬() {
        int arr[] = {11, 7, 5, 6, 10, 9};
        // 7 11
        // 7 11 5 -> 7 5 11 -> 5 7 11
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    tmp = arr[j+1];  // 작은값 갱신
                    arr[j+1]= arr[j];
                    arr[j] = tmp;
                }
            }
            for(int k=0; k < arr.length; k++) {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

    public void LRU알고리즘() {
        int arr[] = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        
    }

}
