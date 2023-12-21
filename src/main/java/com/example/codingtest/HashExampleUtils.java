package com.example.codingtest;

import java.util.*;

public class HashExampleUtils {


    /**
     * str 예시 BACBACCACCBDEDE
     * @param str
     * 설명
     * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
     * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
     * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
     * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
     * 입력
     * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
     * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
     * 출력
     * 학급 회장으로 선택된 기호를 출력합니다.
     *
     * 예시 입력
     * 15
     * BACBACCACCBDEDE
     *
     * 예시출력
     * C
     */
    public void 학급회장선출(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char X : str.toCharArray()) {
            map.put(X, map.getOrDefault(X, 0)+1);
        }

        StringBuilder sb = new StringBuilder();


        int max = Integer.MIN_VALUE;
        String 반장 = "";
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                반장 = String.valueOf(key);
            }
        }

        System.out.println(반장);
    }

    // 매출액의 종류가 몇가지인지 출력
    public void 매출액종류() {
        int N = 7; // 7일간의 매출기록
        int K = 4; // 4일 매출종류
        int arr[] = {20, 12, 20, 10, 23, 17, 10};
        HashMap<Integer, Integer> map = new HashMap<>();

        // 반복적인 작업 전 (= k-1 까지)만 작업함
        for(int i = 0; i < K-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1 );
        }

        int lt = 0;
        for(int rt = K-1; rt < N ; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            System.out.println(map.keySet().size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }
    }

    public void 모든아나그램찾기() {
        String T = "abc";
        String S = "bacaAacba";
        char[] SArray = S.toCharArray();

        HashMap<Character, Integer> TMap = new HashMap<>();
        HashMap<Character, Integer> SMap = new HashMap<>();

        for(char X : T.toCharArray()) {
            TMap.put(X, TMap.getOrDefault(X, 0)+1);
        }

        for(int i = 0 ; i < T.toCharArray().length - 1;i++) {
            SMap.put(SArray[i], SMap.getOrDefault(SArray[i], 0) + 1);
        }

        int resultCount = 0;
        int lt = 0;
        for(int rt = T.toCharArray().length -1; rt < SArray.length; rt++) {
            SMap.put(SArray[rt], SMap.getOrDefault(SArray[rt], 0)+1);
            if(SMap.equals(TMap)) {
                resultCount++;
            }
            SMap.put(SArray[lt], SMap.getOrDefault(SArray[lt], 0)-1);
            if(SMap.get(SArray[lt]) == 0) {
                SMap.remove(SArray[lt]);
            }
            lt++;
        }

        System.out.println(resultCount);
    }

    public void K번째큰수() {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
    }


    class BadHash {
        private int value;

        public BadHash(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            // 모든 객체에 대해 동일한 해시코드를 반환
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BadHash badHash = (BadHash) obj;
            return value == badHash.value;
        }
   }

   public void BadHashExample() {
        HashSet<BadHash> set = new HashSet<>();
        set.add(new BadHash(1));
        set.add(new BadHash(2));
        set.add(new BadHash(3));
   }



}

