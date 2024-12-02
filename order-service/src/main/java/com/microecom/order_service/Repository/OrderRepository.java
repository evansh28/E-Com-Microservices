package com.microecom.order_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.order_service.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
