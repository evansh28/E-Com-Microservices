package com.microecom.order_service.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microecom.order_service.Client.CustomerClient;
import com.microecom.order_service.Client.PaymentClient;
import com.microecom.order_service.Client.ProductClient;
import com.microecom.order_service.Kafka.OrderProducer;
import com.microecom.order_service.Model.OrderConfirmation;
import com.microecom.order_service.Model.OrderLineRequesr;
import com.microecom.order_service.Model.OrderRequest;
import com.microecom.order_service.Model.OrderResponse;
import com.microecom.order_service.Model.PaymentRequest;
import com.microecom.order_service.Model.PurchaseRequest;
import com.microecom.order_service.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private CustomerClient customerClient;

    private OrderMapper orderMapper;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProducer orderProducer;

    @Autowired
    private PaymentClient paymentClient;

    public Integer placeOrder(OrderRequest request) {

        var customer = customerClient.fingCustomerById(request.customerId())
                .orElseThrow(() -> new RuntimeException("Customer not Found"));

        var purchaseProduct = productClient.purchaseProduct(request.products());

        var order = orderRepository.save(orderMapper.toOrder(request));

        for (PurchaseRequest purReq : request.products()) {
            orderLineService.saveorderLine(
                    new OrderLineRequesr(null, order.getId(), purReq.id(), purReq.quantity()));
        }

        var paymentRequest = new PaymentRequest(request.amount(), request.paymentMethod(), order.getId(), order.getRefrence(), customer);

        paymentClient.orderPaymentrequest(paymentRequest);

        orderProducer.sendConfirmation(
                new OrderConfirmation(request.refrence(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProduct));

        return order.getId();
    }

    public List<OrderResponse> getall() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse getById(Integer id) {
        return orderRepository.findById(id).map(orderMapper::fromOrder)
                .orElseThrow(() -> new RuntimeException("Order id is invalid"));
    }

}
