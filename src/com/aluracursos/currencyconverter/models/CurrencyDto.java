package com.aluracursos.currencyconverter.models;

import java.util.Map;
/**
 * @author Manuel Aguilera
 */
public record CurrencyDto(
        Map<String, String> conversion_rates ) {

    @Override
    public String toString() {
        return conversion_rates().values().toString();
    }
}
