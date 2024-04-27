package com.aluracursos.currencyconverter.main;

import com.aluracursos.currencyconverter.api.ApiConnector;

/**
 * @author Manuel Aguilera
 */
public class Main {

    public static void main(String[] args){
        System.out.printf("testing %n%s",ApiConnector.apiRequest("USD"));
    }
}
