package com.main.comm.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import nonapi.io.github.classgraph.json.JSONDeserializer;
import nonapi.io.github.classgraph.json.JSONSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    // producer 설정
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        // broker 관련 설정
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JSONSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // consumer 설정
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        // broker에 대해 consume 하겠다는 설정
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        // 컨슈머 그룹은 리스너에서 지정
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");

        // deserialize 설정
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);    // String 기반
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JSONDeserializer.class);    // Json 방식

        // trusted packages 설정 - 이 설정은 kakfa 메시지 헤더에 있는 객체 정보를 읽는데 어떤 패키지를 읽을것인지에 대한 설정
        // *가 아닐 경우 패키지를 지정하는데 해당 패키지에 없으면 설정에 따라 retry를 하는등 exception 발생함
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");    // 상관없이 모든 객체를 받는다는 의미

        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>());
    }

    // kafka listener 설정
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
