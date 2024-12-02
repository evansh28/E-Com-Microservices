package com.microecom.order_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microecom.order_service.Model.OrderLineResponse;
import com.microecom.order_service.Service.OrderLineService;

@RestController
@RequestMapping("/api/v1/order-line")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("/orders/{id}")
    public ResponseEntity<List<OrderLineResponse>> getAllOrdersId(@PathVariable Integer id){
        return ResponseEntity.ok(orderLineService.getAllOrdersId(id));
    }
    
}
