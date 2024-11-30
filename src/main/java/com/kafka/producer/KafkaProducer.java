package com.kafka.producer;

import com.kafka.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

@Configuration
public class KafkaProducer {

    @Value("${spring.kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void sendMessage(Product product) {
        CompletableFuture<SendResult<String, Product>> future = kafkaTemplate.send(topicName, product);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + product.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        product.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
