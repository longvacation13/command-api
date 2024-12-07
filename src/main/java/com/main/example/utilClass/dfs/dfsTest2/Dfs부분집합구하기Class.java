package com.main.example.utilClass.dfs.dfsTest2;

/**
 * 자연수 n 이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
 */
public class Dfs부분집합구하기Class {

    static int[] ch;
    static int N;

    public Dfs부분집합구하기Class(int N) {
        this.N = N;
    }

    public void DFS(int L) {
        if(L == N+1) { // N까지만 보고 그 다음 넘어가면 출력하는 구조
            for(int i = 1; i < ch.length; i++) {
                if(ch[i] == 1) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        } else {
            ch[L] = 1;   // o
            DFS(L+1); // 왼쪽

            ch[L] = 0;    // x
            DFS(L+1);  // 오른쪽

        }
    }


    public void N의부분집합출력() {
        ch = new int[this.N+1];
        DFS(1); // DFS는 1에서부터 올라감
    }
}
