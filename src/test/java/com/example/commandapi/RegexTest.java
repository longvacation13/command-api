package com.example.commandapi;

import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    public void MyRegexTest() {
        String s = "000.12.12.034";
        System.out.println(s.matches(new MyRegex().pattern));
        System.out.println(s.matches(MyStaticRegex.pattern));
    }
}

class MyRegex {
    //250-255
    //200-249
    //000-199
    //마지막에 점.
    //똑같이 반복
    //마지막에 점. 없음
    String pattern = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})";

}

class MyStaticRegex {
    //250-255
    //200-249
    //000-199
    //마지막에 점.
    //똑같이 반복
    //마지막에 점. 없음
    static String pattern = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})";
}
