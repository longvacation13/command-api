package com.example.codingtest;

public class RecuresiveExample {


    // 10진수 숫자 N이 입력되면 2진수로 변환하여 출력하는 프로그램 작성
    public void DFSExample1(int N) {
        if((N / 2) > 2) {
            DFSExample1((N / 2));
            System.out.print(N % 2);
        } else {
            System.out.print(N / 2); // 몫
            System.out.print(N % 2);   // 나머지
        }
    }

    public void DFS피보나치(int N) {

    }


    /**
     * 전위순회 : 부모 -> 왼 -> 오
     * 중위순회 : 왼 -> 부모 -> 오
     * 후위순회 : 왼 -> 오 -> 부모
     */


    public int 팩토리얼(int N) {
        if(N == 1) {
            return 1;
        } else {
            return N * 팩토리얼(N-1);
        }
    }

}
