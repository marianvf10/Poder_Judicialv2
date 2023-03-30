package com.rpcwebservice.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class InstrumentoConverter implements AttributeConverter<Instrumento, String> {
    @Override
    public String convertToDatabaseColumn(Instrumento instrumento) {
        if (instrumento == null) {
            return null;
        }
        return instrumento.getCode();
    }

    @Override
    public Instrumento convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Instrumento.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
