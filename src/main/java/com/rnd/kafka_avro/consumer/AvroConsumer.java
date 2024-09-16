package com.rnd.kafka_avro.consumer;

import com.rnd.kafka_avro.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AvroConsumer {

    @KafkaListener(topics = "${kafka.topic.name}")
    public void consume(ConsumerRecord<String, Product> consumerRecord) {
        String key = consumerRecord.key();
        Product product = consumerRecord.value();
        log.info("Success consume data, key=" + key + " , value= " + product.toString());
    }
}
