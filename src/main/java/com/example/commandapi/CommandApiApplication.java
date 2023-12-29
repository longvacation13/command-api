package com.example.commandapi;


import com.example.codingtest.*;
import com.example.utilClass.bfs.BfsClass;
import com.example.utilClass.dfs.Dfs부분집합구하기Class;
import com.example.utilClass.dfs.Dfs이진트리순회Class;
import com.example.utilClass.dynamic.LongestSubString;
import com.example.utilClass.dynamic.부분증가수열;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class CommandApiApplication {
    public static void main(String[] args) throws IOException {

        StringExampleUtils test = new StringExampleUtils();
        ArrayExampleUtils arrayExampleUtils = new ArrayExampleUtils();



         String t1 = "asdfj-sadjflkasdj0-sadjflksadj-";
         int idx = t1.indexOf('-');
         while(idx >= 0) {
             System.out.println(idx);
             System.out.println(t1.charAt(idx));
             idx = t1.indexOf("-", idx+1);
         }

        Arrays.asList(0);
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();



    }

}
