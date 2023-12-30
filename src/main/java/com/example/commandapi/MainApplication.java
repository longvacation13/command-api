package com.example.commandapi;


import com.example.utilClass.bfstest2.BfsClassTest2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;import java.util.Stack;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class MainApplication {
    public static void main(String[] args) throws IOException {

        BfsClassTest2 b1 = new BfsClassTest2();
        b1.test();

    }

}
