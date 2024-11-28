package com.microecom.product_service.Model;

import java.math.BigDecimal;



public record ProductResponse(

    Integer id,
    String name,
    String descricption,
    double availableQuantity,
    BigDecimal price,
    Integer categoryId,
    String categoryName,
    String categoryDiscp

) {
    
}
