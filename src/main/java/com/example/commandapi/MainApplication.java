package com.example.commandapi;


import com.example.codingtest.*;
import com.example.utilClass.bfstest2.BfsClassTest2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class MainApplication {
    public static void main(String[] args) throws IOException {

        //BfsClassTest2 b1 = new BfsClassTest2();
        //b1.test();

//        StringExampleUtils s1 = new StringExampleUtils();
//        System.out.println(s1.StringToInteger());
        //System.out.println("Integer MAX VALUE : "+Integer.MAX_VALUE);
        //System.out.println("Integer MIN VALUE : "+Integer.MIN_VALUE);

        //CpCodingTest test = new CpCodingTest();
        //test.test();


        LeetCodeTest test = new LeetCodeTest();
        //test.ContainerWithMostWater();
        //test.IntegerToRoman();
        //test.threeSum();
        //test.letterCombinations();

        SortingExampleUtils s1 = new SortingExampleUtils();
        //s1.좌표정렬();

        GreedyExampleUtils g1 = new GreedyExampleUtils();
        //g1.씨름선수();


        LetterCombinations l1 = new LetterCombinations();
        //l1.test();

        RecuresiveExample r1 = new RecuresiveExample();
        int a = r1.팩토리얼(10);
        System.out.println(a); 

    }

}
