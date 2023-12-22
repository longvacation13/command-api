package com.example.codingtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class QueueAndStackUtils {

    public void 올바은괄호() {
        String str = "(())()";
        //String str = "())))";
        Stack<Character> st = new Stack<>();
        char[] strArr = str.toCharArray();
        String result = "TRUE";

        for(char X : strArr) {
            if(String.valueOf(X).equals("(")) {
                st.push(X);
            } else {
                if(st.isEmpty()) {
                    // ) 가 더 많은 경우
                    result = "FALSE";
                    break;
                }
                st.pop();
            }
        }

        // ( 가 더 많은 경우
        if(st.size() >= 1) {
            result = "FALSE";
        }

        System.out.println(result);
    }

    public void 소괄호사이문자제거() {
        String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        char[] strArr = str.toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char X : strArr) {
            if(String.valueOf(X).equals("(")) {
                st.push(X);
            } else if(String.valueOf(X).equals(")")) {
                st.pop();
            } else if(st.isEmpty()){
                sb.append(X);
            }
        }

        System.out.println(sb.toString());
    }

    /**
     * 크레인 인형뽑기
     * STACK
     */
    public void 크레인인형뽑기() {
        int arr[][] = { {0, 0, 0, 0, 0}
                      , {0, 0, 1, 0, 3}
                      , {0, 2, 5, 0, 1}
                      , {4, 2, 4, 4, 2}
                      , {3, 5, 1, 3, 1}
        };

        HashMap<Integer, Stack<Integer>> mapStack = new HashMap<>();
        for(int i = 0; i < 5 ; i++) {
            Stack<Integer> st = new Stack<>();
            for(int j = 4; j > 0; j--) {
                if(arr[j][i] != 0) {
                    st.push(arr[j][i]);
                }
            }
            mapStack.put(i, st);
        }

        Stack<Integer> resultStack = new Stack<>();
        int resultCount = 0;
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};
        for(int i : move) {
            Stack<Integer> st = mapStack.get(i-1);
            if(resultStack.isEmpty()) {
                resultStack.push(st.pop());
                //mapStack.put(i-1, st);
            }
            else if(st.isEmpty()) {
                continue;
            }
            else if(resultStack.peek() == st.peek()) {
                st.pop();
                resultStack.pop();
                resultCount += 2;
                //mapStack.put(i-1, st);
            } else {
                resultStack.push(st.pop());
                //mapStack.put(i-1, st);
            }

        }
        System.out.println(resultCount);
    }
    public void 후위식연산() {
        String str = "352+*9-";
        char[] strArr = str.toCharArray();


        Stack<Integer> st = new Stack<>();

        for(char X : strArr) {
            // 사칙연산에 해당될 경우
            if(String.valueOf(X).equals("+") || String.valueOf(X).equals("-") || String.valueOf(X).equals("*") || String.valueOf(X).equals("/")) {
                Integer s2 = st.pop();
                Integer s1 = st.pop();
                if(String.valueOf(X).equals("+")) {
                    st.push(s1 + s2);
                } else if(String.valueOf(X).equals("-")) {
                    st.push(s1 - s2);
                } else if(String.valueOf(X).equals("*")) {
                    st.push(s1 * s2);
                } else if(String.valueOf(X).equals("/")) {
                    st.push(s1 / s2);
                }
            } else {
                // 사칙연산에 해당되지 않을 경우 -> stack에 쌓음
                st.push(Integer.parseInt(String.valueOf(X)));
            }
        }
        System.out.println(st.peek());
    }


    public void 쇠막대기(){
        String str = "()(((()())(())()))(())a";
        char[] strArr = str.toCharArray();
        Stack<Character> st = new Stack<>();
        int resultCount = 0;
        int i = 0;

        while(i < strArr.length - 1) {
            String a = String.valueOf(strArr[i])+String.valueOf(strArr[i+1]);
            if(a.equals("()")) {
                resultCount += st.size();
                i = i + 2;
            } else {
                if(String.valueOf(strArr[i]).equals("(")) {
                    st.push(strArr[i]);
                } else if(String.valueOf(strArr[i]).equals(")")) {
                    if(st.isEmpty()) {
                        i++;
                        continue;
                    }
                    resultCount++;
                    st.pop();
                }
                i++;
            }
        }
        System.out.println(resultCount);

    }



}
