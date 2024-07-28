package com.chtrembl.petstore.product.model;


import com.chtrembl.petstore.product.model.Product.StatusEnum;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum statusEnum) {
        return statusEnum.getValue();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String string) {
        return StatusEnum.fromValue(string);
    }
}
