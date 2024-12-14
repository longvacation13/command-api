package com.main.kafkabroker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

@Configuration
public class EmbeddedKafkaConfig {

    @Bean
    public EmbeddedKafkaBroker embeddedKafkaBroker() {
        // 파티션 1개, 브로커 1개로 Embedded Kafka 실행
        EmbeddedKafkaBroker broker = new EmbeddedKafkaBroker(1)
                                        .kafkaPorts(9092)
                                        .brokerProperty("log.dir", "embbeded-kafka-logs"); // 로그 디렉토리 설정
        return broker;
    }

}
