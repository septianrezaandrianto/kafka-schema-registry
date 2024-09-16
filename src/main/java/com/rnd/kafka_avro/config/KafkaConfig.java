package com.rnd.kafka_avro.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.name}")
    private String kafkaTopicName;
    @Value("${kafka.partition}")
    private int kafkaTopicPartition;
    @Value("${kafka.replicate}")
    private short kafkaReplicate;

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(kafkaTopicName, kafkaTopicPartition, kafkaReplicate);
    }
}
