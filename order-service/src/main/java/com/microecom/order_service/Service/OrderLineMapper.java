package com.microecom.order_service.Service;

import org.springframework.stereotype.Service;

import com.microecom.order_service.Model.Order;
import com.microecom.order_service.Model.OrderLine;
import com.microecom.order_service.Model.OrderLineRequesr;
import com.microecom.order_service.Model.OrderLineResponse;

@Service
public class OrderLineMapper {

    public OrderLine toOrder(OrderLineRequesr orderLineRequesr) {
        
        return OrderLine.builder()
        .id(orderLineRequesr.id())
        .quantity(orderLineRequesr.quantity())
        .order(Order.builder().id(orderLineRequesr.orderId()).build())
        .productId(orderLineRequesr.productId())
        .build();

    }

    public OrderLineResponse toOrder(OrderLine orderLine){
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
    
}
