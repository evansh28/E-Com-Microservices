package com.microecom.product_service.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microecom.product_service.Exceptions.ProductPurchaseException;
import com.microecom.product_service.Model.ProductPurchaseRequest;
import com.microecom.product_service.Model.ProductPurchaseResponce;
import com.microecom.product_service.Model.ProductRequest;
import com.microecom.product_service.Model.ProductResponse;
import com.microecom.product_service.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Integer addProduct(ProductRequest request) {

        var product = productMapper.toProduct(request);

        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponce> purchaseProduct(List<ProductPurchaseRequest> request) {

        var productId = request.stream().map(ProductPurchaseRequest::productId).toList();

        var storedProduct = productRepository.findAllByIdInOrderById(productId);

        if (productId.size() != storedProduct.size()) {
            throw new ProductPurchaseException("One or More Product are Not Available");
        }

        var storesRequest = request.stream().sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();

        var productPurchased = new ArrayList<ProductPurchaseResponce>();

        for(int i = 0; i < storedProduct.size(); i++){
            var product = storedProduct.get(i);
            var productRequested = storesRequest.get(i);

            if(product.getAvailableQuantity() < productRequested.quantity()){

                throw new ProductPurchaseException("You Can't Proceed this purchase Because there is No required Quantity Available.");

            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequested.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);

            productPurchased.add(productMapper.toProductPurchaseResponse(product, productRequested.quantity()));
        }

        return null;
    }

    public ProductResponse getAllById(Integer id) {

        return productRepository.findById(id).map(productMapper::toProductResponse)
                .orElseThrow(() -> new RuntimeException("No Product Found"));

    }

    public List<ProductResponse> getAll() {

        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

}
