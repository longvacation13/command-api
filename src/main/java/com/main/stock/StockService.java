package com.main.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {
    @KafkaListener(topics = "payment-success")
    public void reserveStock(String preOrderId) {
        this.reserve(preOrderId);
    }

    @KafkaListener(topics = "payment-failed")
    public void releaseStock(String preOrderId) {
        this.release(preOrderId);
    }

    // 재고 예약처리
    private void reserve(String preOrderId) {
        log.info("stock is reserved. preOrderId : {}", preOrderId);
    }

    // 재고 롤백 처리
    private void release(String preOrderId) {
        log.info("stock is released. preOrderId : {}", preOrderId);
    }
}
