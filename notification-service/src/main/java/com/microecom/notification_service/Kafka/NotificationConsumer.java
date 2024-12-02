package com.microecom.notification_service.Kafka;

import static com.microecom.notification_service.Models.NotificationType.ORDER_CONFIRMATION;
import static com.microecom.notification_service.Models.NotificationType.PAYMENT_CONFIRMATION;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.microecom.notification_service.Models.Notification;
import com.microecom.notification_service.Models.OrderConfirmation;
import com.microecom.notification_service.Models.PaymentConfirmation;
import com.microecom.notification_service.Repository.NotificationRepository;
import com.microecom.notification_service.Services.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessfulNotification(PaymentConfirmation confirmation) throws MessagingException {
        log.info(String.format("Consumeing the message from the payment-topic", confirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDateTime(LocalDateTime.now())
                        .paymentConfirmation(confirmation)
                        .build());

        var customerName = confirmation.customerFirstName() + " " + confirmation.customerLastName();

        emailService.sendPaymentSuccessfullemail(confirmation.customerEmail(), customerName, confirmation.amount(),
                confirmation.orderRefrence());

    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessfulNotification(OrderConfirmation confirmation) throws MessagingException {
        log.info(String.format("Consumeing the message from the order-topic", confirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDateTime(LocalDateTime.now())
                        .orderConfirmation(confirmation)
                        .build());

        var customerName = confirmation.customer().firstName() + " " + confirmation.customer().lastName();

        emailService.sendOrderSuccessfullemail(confirmation.customer().email(), customerName, confirmation.totalAmount(),
                confirmation.orderRefrence(), confirmation.products());

    }

}
