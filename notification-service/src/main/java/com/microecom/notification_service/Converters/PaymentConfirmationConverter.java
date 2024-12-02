package com.microecom.notification_service.Converters;

import com.google.gson.Gson;
import com.microecom.notification_service.Models.PaymentConfirmation;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PaymentConfirmationConverter implements AttributeConverter<PaymentConfirmation, String> {
    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(PaymentConfirmation attribute) {
        return gson.toJson(attribute); // Serialize to JSON
    }

    @Override
    public PaymentConfirmation convertToEntityAttribute(String dbData) {
        return gson.fromJson(dbData, PaymentConfirmation.class); // Deserialize from JSON
    }
}

