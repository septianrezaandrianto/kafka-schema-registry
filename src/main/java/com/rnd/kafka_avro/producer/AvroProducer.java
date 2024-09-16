package com.rnd.kafka_avro.producer;

import com.rnd.kafka_avro.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AvroProducer {

    @Value("${kafka.topic.name}")
    private String kafkaTopicName;

    @Autowired
    private KafkaTemplate<String, Product> template;

    public void send(Product product) {
        CompletableFuture<SendResult<String, Product>> future = template.send(kafkaTopicName, UUID.randomUUID().toString(), product);
        future.whenComplete((result, ex) -> {
            if(Objects.isNull(ex)) {
               log.info("Success send message = [" + product + " ], offset = " + result.getRecordMetadata().offset());
            } else {
                log.info("Failed send message = [ " + product + "], because of " + ex.getMessage());
            }
        });
    }

}
