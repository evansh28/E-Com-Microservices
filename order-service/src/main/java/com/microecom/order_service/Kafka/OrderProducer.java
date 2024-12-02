package com.microecom.order_service.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.microecom.order_service.Model.OrderConfirmation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, OrderConfirmation> kafkaTemplate;

    public void sendConfirmation(OrderConfirmation orderConfirm) {

        log.info("Sending Order Confirmation");
        Message<OrderConfirmation> message = MessageBuilder.withPayload(orderConfirm)
                .setHeader(KafkaHeaders.TOPIC, "Order-Topic").build();
        kafkaTemplate.send(message);

    }

}
