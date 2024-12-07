package com.main.comm.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.spring6.circuitbreaker.configure.CircuitBreakerConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CustomCircuitBreakerConfig {

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        return CircuitBreakerRegistry.of(defaultCircuitBreakerConfig());
    }

    @Bean
    public CircuitBreakerConfig defaultCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(50)                       // 실패비율임계값
                .slidingWindowSize(5)                           // 슬라이딩윈도우사이즈
                .waitDurationInOpenState(Duration.ofSeconds(5)) // open 상태 유지시간 (5초)
                .permittedNumberOfCallsInHalfOpenState(3)       // half-open 상태에서 허용되는 호출 수
                .recordException(throwable -> throwable instanceof Exception)               // 기록할 예외 조건
                .build();
    }
}
