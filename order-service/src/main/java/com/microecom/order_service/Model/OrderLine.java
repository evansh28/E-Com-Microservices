package com.microecom.order_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class OrderLine {

    private Integer id;

    @ManyToOne
    private Order order;

    private Integer productId;
    private double quantity;

}
