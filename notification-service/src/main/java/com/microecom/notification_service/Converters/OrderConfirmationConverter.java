package com.microecom.notification_service.Converters;


import com.google.gson.Gson;
import com.microecom.notification_service.Models.OrderConfirmation;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrderConfirmationConverter implements AttributeConverter<OrderConfirmation, String> {
    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(OrderConfirmation attribute) {
        return gson.toJson(attribute); // Serialize to JSON
    }

    @Override
    public OrderConfirmation convertToEntityAttribute(String dbData) {
        return gson.fromJson(dbData, OrderConfirmation.class); // Deserialize from JSON
    }
}
