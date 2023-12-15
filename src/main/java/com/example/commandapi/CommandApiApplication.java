package com.example.commandapi;


import com.example.codingtest.ArrayExampleUtils;
import com.example.codingtest.BackJunExampleUtils;
import com.example.codingtest.PointerExampleUtils;
import com.example.codingtest.StringExampleUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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
        PointerExampleUtils utils = new PointerExampleUtils();
        utils.두배열합치기(10, 7);

    }

}
