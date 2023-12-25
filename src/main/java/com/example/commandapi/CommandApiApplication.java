package com.example.commandapi;


import com.example.codingtest.*;
import com.example.utilClass.dfs.Dfs부분집합구하기Class;
import com.example.utilClass.dfs.Dfs이진트리순회Class;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class CommandApiApplication {
    public static void main(String[] args) throws IOException {

        StringExampleUtils test = new StringExampleUtils();
        ArrayExampleUtils arrayExampleUtils = new ArrayExampleUtils();

        //test.duplicateCharacterDelete("ksekkset");
        //test.leehyolee("found7, time: study; Yduts; emit, 7Dnuof");
        //test.outputOnlyNumbers("tge0a1h205er");

        //test.shortestWordsDistance("teachermode","e");
        //test.zipString("KKHSSSSSSSE");
        //test.zipString("KSTTTSEEKFKKKDJJGG");
        // KST3SE2KFK3DJ2G
        // KST3SE2KFK3DJ2G2
        //test.decryptWords("#****###**#####**#####**##**");

        //Scanner in = new Scanner(System.in);
        //int input1 = in.nextInt();
        //arrayExampleUtils.biggerWords(input1);

        /** RockPaperScissors
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        List<Integer> arrayA = new ArrayList<>();
        List<Integer> arrayB = new ArrayList<>();

        for(int i = 0; i < input1 ; i++) {
            arrayA.add(in.nextInt());
        }


        for(int i = 0; i < input1 ; i++) {
            arrayB.add(in.nextInt());
        }

        arrayExampleUtils.RockPaperScissors(arrayA, arrayB);
        */


        /**
         * 피보나치
         */
        //arrayExampleUtils.pivonachiCacluatation(10);

        /**
         * 분산처리
         */
        //BackJunExampleUtils backJunExampleUtils = new BackJunExampleUtils();
        //backJunExampleUtils.distributedProcess(7, 100);

        /**
         * 소수찾기
         * 에스테라노스 체
         */
        //arrayExampleUtils.findSosu(20);


        /**
         * 뒤집은 소수 찾기


        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < input1 ; i++) {
            list.add(in.nextInt());
        }
        System.out.println(list.toString());
        //arrayExampleUtils.reverseSosu(Arrays.asList(32, 55, 62, 20, 250, 370, 200, 30, 100));*/


//        List<Integer> list = new ArrayList<>();
//        //list = Arrays.asList(1, 0, 1, 1, 1, 0, 0, 1, 1, 0);
//        list = Arrays.asList(0, 1, 0, 0, 1, 0, 1, 1, 0, 0);
//        System.out.println(list);
//
//        arrayExampleUtils.누적합계산(list);

//        List<Integer> list = new ArrayList<>();
//        list = Arrays.asList(87, 89, 92, 100, 76);
//        arrayExampleUtils.등수계산(list);

          //arrayExampleUtils.격자최대합(5);
          //arrayExampleUtils.봉우리의갯수(5);
         //arrayExampleUtils.임시반장정하기(5);
        //arrayExampleUtils.멘토링(4, 3);

        //PointerExampleUtils utils = new PointerExampleUtils();
        //utils.두배열합치기(10, 7);
        //utils.공통원소찾기();
        //utils.최대매출찾기(10, 3);
        //utils.연속부분수열(100, 100);
        //utils.연속된자연수의합(15);


        //LinkedListExampleUtils linkedListExampleUtils = new LinkedListExampleUtils();
        //linkedListExampleUtils.LinkedListNodeTest();

        HashExampleUtils hashUtils = new HashExampleUtils();
        //hashUtils.학급회장선출("BACBACCACCBDEDE");

        //hashUtils.매출액종류();
        //hashUtils.모든아나그램찾기();

        //hashUtils.K번째큰수();
        //hashUtils.BadHashExample();

        QueueAndStackUtils queueAndStackUtils = new QueueAndStackUtils();
        //queueAndStackUtils.올바은괄호();
        //queueAndStackUtils.소괄호사이문자제거();
        //queueAndStackUtils.크레인인형뽑기();

        //queueAndStackUtils.후위식연산();
        //queueAndStackUtils.쇠막대기();
        //queueAndStackUtils.공주구하기();

        SortingExampleUtils sortingExampleUtils = new SortingExampleUtils();
        //sortingExampleUtils.선택정렬();
        //sortingExampleUtils.버블정렬();
        //sortingExampleUtils.삽입정렬();
        //sortingExampleUtils.LRU알고리즘();
        //sortingExampleUtils.버블정렬연습();
        //sortingExampleUtils.이분검색();
        //sortingExampleUtils.결정알고리즘();
        //sortingExampleUtils.마구간정하기();


        RecuresiveExample recuresiveExample = new RecuresiveExample();
        //recuresiveExample.DFSExample1(238);

        // 이진트리순회(DFS)
        Dfs이진트리순회Class n1 = new Dfs이진트리순회Class();
        //n1.DFSTest();


        Dfs부분집합구하기Class n2 = new Dfs부분집합구하기Class(3);
        n2.N의부분집합출력();



    }

}
