package com.microecom.notification_service.Models;

import static jakarta.persistence.EnumType.STRING;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    
    private NotificationType type;

    @Enumerated(STRING)
    private LocalDateTime notificationDateTime;

    @OneToOne
    private OrderConfirmation orderConfirmation;

    @OneToOne
    private PaymentConfirmation paymentConfirmation;
    
}
