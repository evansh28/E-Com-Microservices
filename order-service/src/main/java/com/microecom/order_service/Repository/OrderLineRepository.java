package com.microecom.order_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.order_service.Model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

    List<OrderLine> findAllByOrderId(Integer id);
    
}
