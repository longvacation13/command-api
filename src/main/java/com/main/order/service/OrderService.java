package com.main.order.service;

import com.main.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createOrder(OrderRequest request) {
        kafkaTemplate.send("order-created", this.saveOrder(request));
    }

    @KafkaListener(topics = "payment-failed")
    public void handlePaymentFailed(String orderId) {
        this.cancelOrder(orderId);
    }

    // order id를 반환하는 메서드
    private String saveOrder(OrderRequest request) {
        return request.preOrderId;   // 테스트 목적으로 임의의 번호 반환
    }

    private String cancelOrder(String preOrderId) {
        log.info("order is canceled by cancelOrder preOrderId : {}", preOrderId);
        return preOrderId;
    }

}
