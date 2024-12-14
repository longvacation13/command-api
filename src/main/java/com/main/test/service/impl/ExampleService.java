package com.main.test.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @CircuitBreaker(name="exampleService", fallbackMethod = "fallbackMethod")
    public String unstableService(boolean triggerError) {
        if(triggerError) {
            throw new RuntimeException("Service Failure : Triggered by client");
        }
        return "Service call succeeded!";
    }

    // CircuitBreaker 가 열렸을 때 호출되는 Fallback 메서드
    public String fallbackMethod(boolean triggerError, Throwable throwable) {
        return "Fallback response : Circuit Breaker is OPEN!";
    }
}
