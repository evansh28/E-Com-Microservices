package com.microecom.order_service.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microecom.order_service.Model.OrderLineRequesr;
import com.microecom.order_service.Model.OrderLineResponse;
import com.microecom.order_service.Repository.OrderLineRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private OrderLineMapper orderLineMapper;

    
    public Integer saveorderLine(OrderLineRequesr orderLineRequesr) {
        var order = orderLineMapper.toOrder(orderLineRequesr);

        return orderLineRepository.save(order).getId();
    }



    public List<OrderLineResponse> getAllOrdersId(Integer id) {
        return orderLineRepository.findAllByOrderId(id)
        .stream()
        .map(orderLineMapper::toOrder)
        .collect(Collectors.toList());
    }

    
    
}
