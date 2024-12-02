package com.microecom.payment_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microecom.payment_service.Model.PaymentNotificationRequest;
import com.microecom.payment_service.Model.PaymentRequest;
import com.microecom.payment_service.Repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest paymentRequest) {

        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        notificationProducer.paymentNotification(
           new PaymentNotificationRequest(paymentRequest.orderRefrence(), paymentRequest.amount(), paymentRequest.paymentMethod(), paymentRequest.customer().firstName(), paymentRequest.customer().lastName(), paymentRequest.customer().email())
        );

        return payment.getId();
    }
    
}
