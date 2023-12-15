package com.example.codingtest;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;
import java.util.stream.Stream;

public class ArrayExampleUtils {

    /**
     * 자기보다 큰수를 출력
     * 첫번째수는 무조건 출력함
     * @param count
     * @Desc
     *      1. 카운트 (입력받을 숫자 갯수 = count) 받음
     *      2. 1.의 값 = count를 기반으로 arrayList에 값 저장함
     *      3. arraylist를 가지고 바로 앞수 보다 큰수만 한줄로 출력(sb)
     *        i가 0인 경우만 로직이 따로 있음
     *        i가 1부터는 1과 0번째, 2와 1번째 이런식의 비교를 함
     */
    public void biggerWords(int count){
        StringBuilder response = new StringBuilder();

        Scanner in = new Scanner(System.in);

        List<Integer> arrays = new ArrayList<>();

        // 입력받은 값 저장
        int index = 0;
        while(index < count) {
            int a = in.nextInt();
            arrays.add(a);
            index++;
        }


        for(int i = 0; i < arrays.size(); i++) {
            if(i == 0) {
                // 첫번재 값은 무조건 저장
                response.append(arrays.get(i)+" ");
            } else {
                if(arrays.get(i) > arrays.get(i-1)) {
                    response.append(arrays.get(i)+" ");
                }
            }
        }
        System.out.println(response);

    }

    /**
     * 가위바위보 게임
     * @param arraysA
     * @param arraysB
     * @DESC
     *        A와 B의 가위바위보 정보를 입력함
     *        A가 이길경우 A,  B가 이길경우 B, A와 B가 비길경우 D 를 출력한다.
     *
     * 오류 히스토리
     * /judger/run/9c299f65c46441a6b187a5fce2ff0fae/Main.java:19: error: non-static method RockPaperScissors(List<Integer>,List<Integer>) cannot be referenced from a static context
     *     RockPaperScissors(arrayA, arrayB);
     */
    public void RockPaperScissors(List<Integer> arraysA, List<Integer> arraysB) {

        for(int i = 0; i < arraysA.size(); i++) {
            System.out.println(this.RockPaperScissorsRule(arraysA.get(i), arraysB.get(i)));
        }
    }

    // 각 판별 결과 출력
    public String RockPaperScissorsRule(int a, int b) {
        String response = "";

        if(a == b) {
            response = "D";
        } else {
            switch (a) {
                case 1:
                    if(b == 2) {
                        response = "B";
                    } else {
                        response = "A";
                    }
                    break;
                case 2:
                    if(b == 1) {
                        response = "A";
                    } else {
                        response = "B";
                    }
                    break;
                case 3:
                    if(b == 2) {
                        response = "A";
                    } else {
                        response = "B";
                    }
                    break;
            }
        }

        return response;
    }


    /**
     * 입력받은 숫자 만큼의 피보나치 수열을 출력함
     * @param num
     */
    public void pivonachiCacluatation(int num) {

        final int a0 = 1;
        final int a1 = 1;
        final int a2 = 2;

        List<Integer> response = new ArrayList<>();

        switch (num)
        {
            case 1:
                response.add(a0);
                break;
            case 2:
                response.add(a0);
                response.add(a1);
                break;
            case 3:
                response.add(a0);
                response.add(a1);
                response.add(a2);
                break;
            default:
                response.add(a0);
                response.add(a1);
                response.add(a2);
                for(int i = 3; i < num; i++) {
                    response.add(response.get(i-1) + response.get(i-2));
                }
        }
        for(int a : response) {
            System.out.print(a+" ");
        }
    }

    /**
     * 소수찾기
     * @param lastNum
     * @Desc
     *      마지막 번호(lastNum)을 입력받으면 소수를 찾음
     */
    public void findSosu(int lastNum) {
        //lastNum = lastNum + 1;

        HashSet<Integer> set = new HashSet<>();
        int response = 0;
        int count = 0;

        // 1보다 작을 경우
        if(lastNum <= 1) {
            System.out.println("response : "+response);
        }
        // 2보다 클 경우
        else
        {

            int index = 2;

            // 2부터 시작
            while(index <= lastNum) {

                // 해당 숫자를 포함하지 않을 경우
                // 1. 소수로 인식 -> count + 1
                // 2. 해당 숫자의 배수를 모두 set에 넣음 ( index * i 가 lastNum보다 작거나 같을때까지 )
                if(!set.contains(index))
                {
                    //System.out.println("index number : "+index);
                    count++;
                    set.add(index);
                    // index의 배수들을 전부 set에 넣음
                    for(int i = 1 ; index * i <= lastNum ; i++) {
                        //System.out.println("index number * i = "+index * i);
                        set.add(index * i);
                    }
                }
                index++;
            }

        }
        System.out.println(count);
    }


    /**
     * 뒤집은 소수
     * @param list
     * 1-1. 문자의마지막 0을 모두 제거 한다.
     * 1-2. 남은 숫자를 reverse 한다.
     * 2-1. 가장 큰수를 찾고 2부터 해당숫자까지의 소수를 찾아냄
     * 2-3. contains true가 아닐경우만 response.add 한다.
     */
    public void reverseSosu(List<Integer> list) {



        List<Integer> reverseArrays = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            StringBuilder array = new StringBuilder(list.get(i)+"");

            int arrayLastIndex = array.length()-1;

            // 마지막에 0이 있을경우 안나올때까지 계속 삭제함
            while(array.substring(arrayLastIndex, arrayLastIndex+1).equals("0")) {
                //System.out.println("array.substring(lastIndex) : "+array.substring(arrayLastIndex));
                array.setCharAt(arrayLastIndex, ' ');
                arrayLastIndex--;
            }
            // 역순으로 뒤집음
            reverseArrays.add(Integer.parseInt(array.reverse().toString().trim()));
        }



        // 1. 2부터 최대값 까지
        HashSet<Integer> set = new HashSet<>();
        int maxValue = Collections.max(reverseArrays);
        //System.out.println("maxValue:"+maxValue);
        int index = 2;

        for(int i = index; i <= maxValue ; i++) {

            if(!set.contains(i)) { // 소수
                for(int j = 2; (j * i) <= maxValue; j++) {
                    set.add(j * i); // 합성수 전체 hashset에 넣음
                }
            }
        }


        for(int i = 0; i < reverseArrays.size(); i++) {

            if(reverseArrays.get(i) == 1) {
                continue;
            }

            if(!set.contains(reverseArrays.get(i))) { // 소수일 경우
                System.out.print(reverseArrays.get(i)+" ");
            }
        }
    }


    public void 누적합계산(List<Integer> arrays){
        int index = 0;
        int totalScore = 0;
        int score = 0;

        for(int i = 0; i < arrays.size(); i++) {
            if(arrays.get(i) == 1){
                score += 1;
            } else {
                score = 0;
            }
            totalScore += score;
        }

        System.out.println(totalScore);
    }

    /**
     * 현재 등수 계산기
     * 등수가 중복될경우 다음 학생은 앞의 등수를 모두 카운트하고 다음 등수가 됨
     * 예를들어 92 92 92 80이면 80점은 4등
     * @param scores
     */
    public void 등수계산(List<Integer> scores) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < scores.size(); i++) {
            int 등수 = 1;
            for(int j = 0; j < scores.size(); j++) {
                if(i != j) {    // 같은 인덱스일때는 계산하지 않음
                    if(scores.get(j) > scores.get(i)) {
                        등수++;
                    }
                }
            }
            result.add(등수);
        }
    }

    /**
     * n X n의 행렬에 최대합을 구한다
     * 각열의 합, 각 행의 합, 두 대각선의 합
     * @param n
     */
    public void 격자최대합(int n) {
        Scanner in = new Scanner(System.in);
        //int[][] array = new int[n][n];

//        for(int i = 0; i < n ; i++) {
//            for(int j =0; j < n ; j++) {
//                array[i][j] = in.nextInt();
//            }
//        }


        int[][] array = {{10,13,10,12,15},{12,39,30,23,11},{11,25,50,53,15},{19,27,29,37,27},{19,13,30,13,19}};

        // 최대합
        int maxSum = 0;
        for(int i =0; i < n; i++) {

            // rowSum
            int index = 0;
            int rowSum = 0;
            int colSum = 0;
            while(index < n) {
                rowSum += array[i][index];
                colSum += array[index][i];
                index++;
            }

            if(rowSum > maxSum) {
                maxSum = rowSum;
            }

            if(colSum > maxSum) {
                maxSum = colSum;
            }
        }

        int 대각합 = 0;
        int 역대각합 = 0;
        for(int i = 0; i < n ; i++) {
            대각합 += array[i][i];
            역대각합 += array[i][(n-1)-i];
        }

        if(대각합 > maxSum) {
            maxSum = 대각합;
        } else if(역대각합 > maxSum) {
            maxSum = 역대각합;
        }
        System.out.println(maxSum);
    }


    public void 봉우리의갯수(int n) {
        Scanner in = new Scanner(System.in);
        int[][] array = new int[n+2][n+2];
        // 첫번째행
        // 첫번째열
        // 마지막행
        // 마지막열 

        int index = 0;
        while(index < n+2) {
            array[0][index] = 0;    // 첫번째행
            array[index][0] = 0;    // 첫번째열
            array[n+1][index] = 0;  // 마지막행
            array[index][n+1] = 0;  // 마지막열
            index++;
        }

        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int 봉우리개수 = 0;
        int rowIndex = 1;
        while(rowIndex <= n) {
            for(int i = 1; i <= n; i++){
                int count = 0;

                if(array[rowIndex][i] > array[rowIndex-1][i]) {
                    count++;
                } else {
                    continue;
                }

                if(array[rowIndex][i] > array[rowIndex+1][i]) {
                    count++;
                } else {
                    continue;
                }

                if(array[rowIndex][i] > array[rowIndex][i-1]) {
                    count++;
                } else {
                    continue;
                }

                if(array[rowIndex][i] > array[rowIndex][i+1]) {
                    count++;
                } else {
                    continue;
                }

                if(count == 4) {
                    봉우리개수++;
                }

            }
            rowIndex++;
        }
        System.out.println("봉우리 개수: "+봉우리개수);
        System.out.println(Arrays.deepToString(array));

    }

    public void 임시반장정하기(int n) {
       int[][] array = {{2, 3, 1, 7, 3},{4, 1, 9, 6, 8},{5, 5, 2 ,4 ,4},{6, 5, 2, 6, 7},{8, 4, 2, 2, 2}};
       int[] arr = new int[n];

       // 고정변수 : 5학년까지만 존재함
        for(int i = 0; i < n; i++) {            // i 라는 학생
            int iCount = 0;
            for(int j = 0; j < n; j++) {        // j 라는 학생
                for(int k=0; k < 5; k++) {
                    if((i != j) && (array[i][k] == array[j][k])) {
                        iCount++;
                    }
                }
            }
            arr[i] = iCount; // i 라는 학생의 같은반되었던 횟수
        }


        int maxValue = 0;
        int maxPerson = 0;
        for(int i = 0; i < n ; i++) {
            if(arr[i] > maxValue) {
                maxPerson = i;
                maxValue = arr[i];
            }
        }
        System.out.println(maxPerson+1);

    }
}