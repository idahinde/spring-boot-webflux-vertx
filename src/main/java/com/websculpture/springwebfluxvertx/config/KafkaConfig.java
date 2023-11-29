package com.websculpture.springwebfluxvertx.config;

import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.kafka.client.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Idris Ishaq
 * @Date: 20 Sep, 2023
 */

@Configuration
public class KafkaConfig {

    @Value("${abaa.kafka-host}")
    private String host;
    @Value("${abaa.kafka-port}")
    private int port;

    @Bean
    @Autowired
    public KafkaProducer<String, JsonObject> kafkaConsumer(Vertx vertx) {
        return KafkaProducer.create(vertx, config(), String.class, JsonObject.class);
    }

    private Map<String, String> config() {
        Map<String, String> config = new HashMap<>();
        config.put("bootstrap.servers", String.format("%s:%s", host, port));
        config.put("key.serializer", "io.vertx.kafka.client.serialization.JsonObjectSerializer");
        config.put("value.serializer", "io.vertx.kafka.client.serialization.JsonObjectSerializer");
        config.put("acks", "1");
        return config;
    }

}
