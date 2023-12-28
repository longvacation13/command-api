package com.example.utilClass.dynamic;

public class StairCase {
    static int[] dy;
    public void solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <=n ; i++) {
            dy[i] = dy[i-2]+dy[i-1];
        }
    }
}
