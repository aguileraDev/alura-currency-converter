package com.aluracursos.currencyconverter.models;

import com.aluracursos.currencyconverter.mapper.CurrencyMapper;

import java.util.NoSuchElementException;



/**
 * @author Manuel Aguilera
 */
public class Conversion {

    public static Double usdConvert(Currency currency, Double value){
        return currency.getValue() * value;
    }

    public static Double toUsd(Currency currency, Double value){
        return value / currency.getValue();
    }


    public static Currency selectCurrency(String symbol){

        try{
            for (Currency currencies : CurrencyMapper.getCurrencies()){
                if(currencies.getSymbol().equals(symbol)){
                    return currencies;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("No se encontro la moneda " + symbol);
        }


        return null;
    }

}