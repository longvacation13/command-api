package com.example.commandapi;


import com.example.codingtest.CpCodingTest;
import com.example.codingtest.LeetCodeTest;
import com.example.codingtest.StringExampleUtils;
import com.example.utilClass.bfstest2.BfsClassTest2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;import java.util.Stack;

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
        test.threeSum();

    }

}
