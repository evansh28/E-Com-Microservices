package com.microecom.order_service.Client;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microecom.order_service.Model.PurchaseRequest;
import com.microecom.order_service.Model.PurchaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate template;

    public List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> requests) {

        HttpHeaders header = new HttpHeaders();
        header.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> request = new HttpEntity<>(requests, header);
        ParameterizedTypeReference<List<PurchaseResponse>> response = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<PurchaseResponse>> responces = template.exchange(productUrl + "/purchase", POST, request,
                response);

        if(responces.getStatusCode().isError()){
            throw new RuntimeException("We have an Error Occured");
        }

                return responces.getBody();

    }

}
