package com.microecom.payment_service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPaymentTopic {

    @Bean
    public NewTopic paymentTopic(){
        return TopicBuilder.name("payment-topic").build();
    }
    
}
