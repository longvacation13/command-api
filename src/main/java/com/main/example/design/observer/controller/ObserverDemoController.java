package com.main.example.design.observer.controller;


import com.main.example.design.observer.util.ConcreteObserver;
import com.main.example.design.observer.util.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 옵저버 패턴 이해를 위해 만든 클래스
 */
@RestController
@RequestMapping("/design")
public class ObserverDemoController {


    // api end point를 정상적으로 찌르는지 확인하기 위한 test method
    @GetMapping("/observer")
    public String helloRequest() {

        Subject subject = new Subject();

        // 옵저버 역할을 수행함
        new ConcreteObserver(subject);
        new ConcreteObserver(subject);
        new ConcreteObserver(subject);

        System.out.println("처음 상태 : 15");
        subject.setState(15);
        System.out.println("새 상태 : 30");
        subject.setState(15);

        return "observer";
    }
}
