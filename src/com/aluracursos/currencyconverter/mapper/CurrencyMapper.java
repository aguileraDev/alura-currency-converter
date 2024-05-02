package com.aluracursos.currencyconverter.mapper;

import com.aluracursos.currencyconverter.models.CurrencyDto;
import com.aluracursos.currencyconverter.models.Currency;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Manuel Aguilera
 */
public class CurrencyMapper {

    private static CurrencyDto currencyData;
    private static List<Currency> currencies = new ArrayList<>();

    public static void jsonToDto(String data){

        Gson gson = new Gson()
                    .newBuilder()
                    .setPrettyPrinting()
                    .create();

        try{
            currencyData = gson.fromJson(data, CurrencyDto.class);

        }catch(JsonSyntaxException e){
            System.out.println("Error en el mapeo de datos");
        }

        filterCurrencies();

    }

    public static void filterCurrencies(){

        List<String> validCurrencies = new ArrayList<>();


        validCurrencies.add("USD");
        validCurrencies.add("COP");
        validCurrencies.add("ARS");
        validCurrencies.add("BRL");

        currencyData.conversion_rates().forEach((key, value) -> {
            if( validCurrencies.contains(key)){
                Currency currency = new Currency(key, Double.valueOf(value));
                currencies.add(currency);
            }
        });


    }

    public static List<Currency> getCurrencies() {
        return currencies;
    }
}
