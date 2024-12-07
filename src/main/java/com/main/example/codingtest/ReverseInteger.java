package com.main.example.codingtest;

import java.util.Stack;

public class ReverseInteger {
    public int reverse(int x) {
        x = 123;
        int a = x < 0 ? -1 : 1;
        x = x < 0 ? x * -1 : x * 1;

        Stack<Integer> s = new Stack<>();

        while(x > 0) {
            s.push(x % 10);
            x /= 10;
        }

        int result = 0;
        int powInt = 1;
        while(s.size() > 0) {
            if(((result / 10) + s.peek() * (powInt / 10))  > (Integer.MAX_VALUE / 10)) {
                result = 0;
                break;
            }
            result += s.pop() * powInt;
            System.out.println("result:"+result);
            powInt*=10;
        }


        return a * result;
    }
}
