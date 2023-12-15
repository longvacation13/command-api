package com.example.codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackJunExampleUtils {

    //private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void distributedProcess(int a, int b) {

        Double result = Math.pow(a, b);

        double computerNum = result % 10;
        System.out.println(computerNum);
        if(computerNum == 0){
            computerNum = 10;
        }


        System.out.println("마지막 데이터가 처리되는 컴퓨터의 번호 : "+computerNum);
    }


}
