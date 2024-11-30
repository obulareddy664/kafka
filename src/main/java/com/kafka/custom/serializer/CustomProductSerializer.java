package com.kafka.custom.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.entity.Product;
import org.apache.kafka.common.serialization.Serializer;
import org.hibernate.type.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomProductSerializer implements Serializer<Product> {

    Logger logger= LoggerFactory.getLogger(CustomProductSerializer.class);

    @Autowired
    private final ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Product data) {
        try{
            if(data==null){
               logger.info("Null received during serialization");
                return null;
            }
            logger.info("Serializing........");
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            logger.error("error received while CustomProductSerializer");
            throw new SerializationException("Error while receiving exception to byte []",e);
        }

    }

    @Override
    public void close() {

    }
}
