package com.aluracursos.currencyconverter.models;

/**
 * @author Manuel Aguilera
 */
public class Currency {
    private String symbol;
    private Double value;

    public Currency(String symbol, Double value){
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }


    public Double getValue() {
        return value;
    }

    @Override
    public String toString(){
        return this.getSymbol()+ " " +this.getValue();
    }
}
