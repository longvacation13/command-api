package com.example.commandapi;


import com.config.CustomException;
import com.example.codingtest.*;
import com.example.utilClass.bfstest2.BfsClassTest2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@SpringBootApplication(scanBasePackages = "com.*")
public class MainApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }

}
