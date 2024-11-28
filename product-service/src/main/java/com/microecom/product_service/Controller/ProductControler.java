package com.microecom.product_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microecom.product_service.Model.ProductPurchaseRequest;
import com.microecom.product_service.Model.ProductPurchaseResponce;
import com.microecom.product_service.Model.ProductRequest;
import com.microecom.product_service.Model.ProductResponse;
import com.microecom.product_service.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/product")
public class ProductControler {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request){

        return ResponseEntity.ok(productService.addProduct(request));

    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponce>> purchase(@RequestBody List<ProductPurchaseRequest> request){

        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @GetMapping("all/{id}")
    public ResponseEntity<ProductResponse> getAllById(@PathVariable Integer id){

        return ResponseEntity.ok(productService.getAllById(id));

    }

    public ResponseEntity<List<ProductResponse>> getAll(){

        return ResponseEntity.ok(productService.getAll());

    }
    
}
