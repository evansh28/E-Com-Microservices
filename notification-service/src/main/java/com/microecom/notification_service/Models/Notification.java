package com.microecom.notification_service.Models;

import static jakarta.persistence.EnumType.STRING;

import java.time.LocalDateTime;

import com.microecom.notification_service.Converters.OrderConfirmationConverter;
import com.microecom.notification_service.Converters.PaymentConfirmationConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Enumerated(STRING)
    private NotificationType type;

    private LocalDateTime notificationDateTime;

    @Convert(converter = OrderConfirmationConverter.class)
    private OrderConfirmation orderConfirmation;

    @Convert(converter = PaymentConfirmationConverter.class)
    private PaymentConfirmation paymentConfirmation;
    
}
