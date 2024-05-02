package com.aluracursos.currencyconverter.main;

import com.aluracursos.currencyconverter.api.ApiConnector;
import com.aluracursos.currencyconverter.models.Conversion;

import java.util.Scanner;

/**
 * @author Manuel Aguilera
 */
public class Main {
    public final static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        ApiConnector.createRequest();
        System.out.println("Bienvenido al convertidor de divisas");

        menu();

    }

    public static void menu(){
        int option = 0;

        do {
            System.out.println("----------------------------------");
            System.out.println("Elige una opcion");
            System.out.println("1.-Convertir dolares a real Brasileño (BRL)");
            System.out.println("2.-Convertir dolares a pesos Colombianos (COP)");
            System.out.println("3.-Convertir dolares a pesos Argentinos (ARS)");
            System.out.println("4.-Convertir pesos Colombianos (COP) a Dolares (USD)");
            System.out.println("5.-Convertir pesos Argentinos (ARS) a Dolares (USD)");
            System.out.println("6.-Convertir Real Brasileño (BRL) a Dolares (USD)");
            System.out.println("7.-Salir");
            System.out.println("----------------------------------");
            option = input.nextInt();

            if( option < 0 || option > 7){
                System.out.println("Opcion invalida");
                option = 0;
            }

            if( option == 1){
                System.out.println(newTransaction("USD","BRL"));
            }

            if( option == 2){
                System.out.println(newTransaction("USD","COP"));
            }

            if( option == 3){
                System.out.println(newTransaction("USD","ARS"));
            }

            if( option == 4){
                System.out.println(newTransaction("COP","USD"));
            }
            if( option == 5){
                System.out.println(newTransaction("ARS","USD"));
            }
            if( option == 6){
                System.out.println(newTransaction("BRL","USD"));
            }

        }while( option != 7);

    }

    public static String newTransaction(String currentCurrency, String currencyExpected ){
            System.out.printf("Ingresa un valor en %s: ", currentCurrency );
            Double valueToConvert = input.nextDouble();
            Double result = 0.0;


            if(currentCurrency.equals("USD")){
                result = Conversion.usdConvert(Conversion.selectCurrency(currencyExpected), valueToConvert);
            }else{
                result = Conversion.toUsd(Conversion.selectCurrency(currentCurrency),valueToConvert);
            }

            return """
                    _______________________________________________
                    %.2f %s equivale a %.2f %s%n
                    _______________________________________________
                    """.formatted(valueToConvert,currentCurrency,result,currencyExpected);

    }
}
