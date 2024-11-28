package com.microecom.product_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.product_service.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findAllByIdInOrderById(List<Integer> productId);
    
}
