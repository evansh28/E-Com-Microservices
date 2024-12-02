package com.microecom.product_service.Service;

import org.springframework.stereotype.Service;

import com.microecom.product_service.Model.Category;
import com.microecom.product_service.Model.Product;
import com.microecom.product_service.Model.ProductPurchaseResponce;
import com.microecom.product_service.Model.ProductRequest;
import com.microecom.product_service.Model.ProductResponse;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        
        return Product.builder()
        .id(request.id())
        .name(request.name())
        .descricption(request.descricption())
        .availableQuantity(request.availableQuantity())
        .price(request.price())
        .category(Category.builder()
        .id(request.categoryId())
        .build())
        .build();

    }

    public ProductResponse toProductResponse(Product product){

        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescricption(),
            product.getAvailableQuantity(),
            product.getPrice(),
            product.getCategory().getId(),
            product.getCategory().getName(),
            product.getCategory().getDescricption()
        );

    }

    public ProductPurchaseResponce toProductPurchaseResponse(Product product,
            double quantity) {
        return new ProductPurchaseResponce(
            product.getId(),
            product.getName(),
            product.getDescricption(),
            product.getPrice(),
            quantity
        );
    }
    
}
