package com.microecom.order_service.Service;

import org.springframework.stereotype.Service;

import com.microecom.order_service.Model.Order;
import com.microecom.order_service.Model.OrderRequest;
import com.microecom.order_service.Model.OrderResponse;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request) {

        return Order.builder()
        .id(request.id())
        .customerId(request.customerId())
        .refrence(request.refrence())
        .totalAmount(request.amount())
        .paymentMethod(request.paymentMethod())
        .build();
        

    }

    public OrderResponse fromOrder(Order order){
        return new OrderResponse(
            order.getId(),
            order.getRefrence(),
            order.getTotalAmount(),
            order.getPaymentMethod(),
            order.getCustomerId()
        );
    }
    
}
