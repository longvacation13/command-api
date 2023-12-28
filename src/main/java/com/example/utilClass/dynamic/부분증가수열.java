package com.example.utilClass.dynamic;

public class 부분증가수열 {
    static int[] dy;

    public void 부분증가수열테스트() {
//        Scanner in=new Scanner(System.in);
//        int N = in.nextInt();
        int[] arr = {0,5,2,18,3,4,7,10,9,11,8,15};
        int N = 11;
        solution(arr);
        return ;
    }

    public void solution(int[] arr) {
        dy = new int[arr.length];
        dy[1] = 1;
        dy[2] = 1;

        for(int i = 3; i < arr.length; i++){

            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {           // 필수조건 1. 탐색하는 arr[i]는 이전항들 arr[j] 보다 커야한다.
                    if(dy[j] > dy[i]) {         // 필수조건 2. 세팅할 dy[i]는 dy[j] 보다 작아야한다. (최대부분증가수열 찾는거기때문)
                        dy[i] = dy[j];          // 위 2가지 조건을 만족할떄 dy[i] = dy[j]가 된다.
                    }
                }
            }
            dy[i]+=1; // 자기 자신을 더해줌
        }

        int maxValue = 0;
        for(int i = 1; i < dy.length; i++) {
            if(dy[i] > maxValue) {
                maxValue = dy[i];
            }
        }
        System.out.println(maxValue);

    }

}
