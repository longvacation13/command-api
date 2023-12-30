package com.example.commandapi;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;import java.util.Stack;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class MainApplication {
    public static void main(String[] args) throws IOException {

        String result = "TURE";
        String s = "(()()))"; // false

        Stack<Character> st = new Stack<>();

        for(char X : s.toCharArray()) {
            if(String.valueOf(X).equals("(")) {
                st.push(X);
            }
        }

        // ) 값을 pop 을 통해 제거 & ) 값이 더 많을경우 FALSE
        for(char X : s.toCharArray()) {
            if(String.valueOf(X).equals(")")) {
                if(st.size() == 0) {
                    // 결과값을 false로 리턴
                    result = "FALSE";
                    break;
                } else {
                    st.pop();
                }
            }
        }

        // ( 더 많을 경우
        if(st.size() > 0) {
            result = "FALSE";
        }

        System.out.print(result);





    }

}
