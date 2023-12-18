package com.example.codingtest;

import java.util.*;

public class PointerExampleUtils {


    /**
     * 아래 두 배열을 순서대로 정렬하시오.
     * 배열을 합쳐서 소팅 -> 최악 O(nLogn) 만큼의 시간복잡도가 소모됨
     * @param n
     * @param m
     */
    public void 두배열합치기(int n, int m) {

        int[] arr1 = {1, 10, 27, 39, 50, 61, 65, 70, 93, 93};
        int[] arr2 = {7, 51, 65, 66, 70, 82, 93};

        int arr1Index = 0;
        int arr2Index = 0;

        List<Integer> result = new ArrayList<>();

        while(result.size() < (n + m)) {
            if(arr1Index == arr1.length) {
                for(int i = arr2Index; i < arr2.length; i++) {
                    result.add(arr2[i]);
                }
                break;
            }

            if(arr2Index == arr2.length) {
                for(int i = arr1Index; i < arr1.length; i++) {
                    result.add(arr1[i]);
                }
                break;
            }




            if(arr1[arr1Index] < arr2[arr2Index]) {
                result.add(arr1[arr1Index]);
                arr1Index++;
            } else if(arr1[arr1Index] > arr2[arr2Index]) {
                result.add(arr2[arr2Index]);
                arr2Index++;
            } else { // 같은 경우
                result.add(arr1[arr1Index]);
                result.add(arr2[arr2Index]);
                arr1Index++;
                arr2Index++;
            }
        }

        System.out.println(result.toString());
    }

    public void 공통원소찾기() {
        int[] arr1 = {1, 3, 9, 5, 2};
        Arrays.sort(arr1); // 1, 2, 3, 5, 9

        int[] arr2 = {3, 2, 5, 7, 8};
        Arrays.sort(arr2); // 2, 3, 5, 7, 8

        List<Integer> resultList = new ArrayList<>();

        int p1 = 0;   // arr1의 포인터
        int p2 = 0;   // arr2의 포인터

        while((p1 < arr1.length) && (p2 < arr2.length)) {
            if(arr1[p1] == arr2[p2]) {
                resultList.add(arr1[p1]);
                p1++;
                p2++;
            } else if(arr1[p1] > arr2[p2]) {
                p2++;
            } else if(arr1[p1] < arr2[p2]) {
                p1++;
            }
        }
        System.out.println(resultList.toString());
    }

    public void 최대매출찾기(int n, int m){
        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15 };

        int maxSum = 0;

        // 첫번째 sum
        for(int i = 0; i < m; i++){
            maxSum += arr[i];
        }
        int sum = 0;
        sum = maxSum;

        for(int i = 1; i < n-m; i++) {
            sum = sum - arr[i-1] + arr[i+(m-1)];
            System.out.println("i : [ "+i+" ], sum : "+sum);
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);

    }

    public void 연속부분수열 (int n, int m) {  // 8 , 6
        int arr[] = {1, 2, 1, 3, 1, 1, 1, 2};


        int sum = arr[0];
        int resultCount = 0;

        int index = 1;
        int startIndex = 0;

        while(index < n) {
            if(sum == m) {
                resultCount++;  // 원소 갯수 +1
                sum = sum - arr[startIndex];
                startIndex++;
            }
            else if(sum < m) {
                sum = sum + arr[index];
                index++;
            } else {    // sum > n
                sum = sum - arr[startIndex];
                startIndex++;
            }
        }

        System.out.println(resultCount);
    }

}

