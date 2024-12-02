package com.microecom.payment_service.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.microecom.payment_service.Model.PaymentNotificationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class NotificationProducer {

    @Autowired
    private KafkaTemplate<String, PaymentNotificationRequest> template;

    public void paymentNotification(PaymentNotificationRequest request) {
        log.info("Sending Payment Message");
        Message<PaymentNotificationRequest> message = MessageBuilder.withPayload(request)
                .setHeader(TOPIC, "Payment-Topic").build();
        
                template.send(message);
    }

}
