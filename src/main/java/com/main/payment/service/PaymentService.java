package com.main.payment.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "order-created")
    public void processPayment(String preOrderId) {
        boolean paymentSuccess = this.makePayment(preOrderId);
        log.info("payment result : {} ", paymentSuccess);
        if(paymentSuccess) {
            kafkaTemplate.send("payment-success", preOrderId);
        } else {
            kafkaTemplate.send("payment-failed", preOrderId);
        }
    }

    private boolean makePayment(String preOrderId) {
        // 임의의 확률로 결제 성공 혹은 실패
        if(Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }

}

