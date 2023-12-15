package com.example.request.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class TestController {


    // api end point를 정상적으로 찌르는지 확인하기 위한 test method
    @GetMapping("/test")
    public String helloRequest() {
        return "hello request!";
    }

}
