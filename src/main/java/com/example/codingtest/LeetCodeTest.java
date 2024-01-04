package com.example.codingtest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCodeTest {

    public void IntegerToRoman() {

        //int num = 3;   // III
        //int num = 53;  // LIII
        int num = 1994;  // MCMXCIV

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        map.put('M', 1000);
//        map.put('D', 500);
//        map.put('C', 100);
//        map.put('L', 50);
//        map.put('X', 10);
//        map.put('V', 5);
//        map.put('I', 1);
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder sb = new StringBuilder();





    }

    /**
     *
     * @param num
     * @return
     * @Desc
     *          number를 받으면 이게 5 * 10 ^ N 인지 혹은 1 * 10 ^ N 인지 확인한다.
     */
    private boolean isPowYn(int num) {
        boolean result = true;

        // 1~9 사이값이 나올때까지 계속 나눗셈 해줌
        while(num / 10 > 1) {
            num /= 10;
        }

        if(num != 1) {
            result = false;
        }

        return result;
    }
}
