package com.kafka.controller;

import com.kafka.entity.Product;
import com.kafka.producer.KafkaProducer;
import com.kafka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    public ResponseEntity sendMeassage(@RequestBody Product product){
//        productRepository.save(product);
        kafkaProducer.sendMessage(product);
        return new ResponseEntity("sent successfully", HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity getAll(){
     List<Product> productList= productRepository.findAll();
     return  new ResponseEntity(productList,HttpStatus.OK);
    }
}
