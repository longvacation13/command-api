package com.main.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "order-created", groupId = "order-group")
    public void processPayment(String preOrderId) {
        try {
            boolean paymentSuccess = this.makePayment(preOrderId);
            log.info("payment result : {} ", paymentSuccess);
            if(paymentSuccess) {
                kafkaTemplate.send("payment-success", preOrderId);
            } else {
                kafkaTemplate.send("payment-failed", preOrderId);
            }
        } catch (Exception e) {
            log.error("Failed to process payment for preOrderId: {}", preOrderId, e);
            // 예외 발생 시 메시지가 재시도되지 않도록 처리 (필요에 따라 수정)
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

