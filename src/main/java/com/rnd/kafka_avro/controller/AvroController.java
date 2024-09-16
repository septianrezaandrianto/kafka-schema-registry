package com.rnd.kafka_avro.controller;

import com.rnd.kafka_avro.dto.Product;
import com.rnd.kafka_avro.producer.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avro")
public class AvroController {

    @Autowired
    private AvroProducer avroProducer;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Product product) {
        avroProducer.send(product);
        return ResponseEntity.ok("Success Send Message");
    }
}
