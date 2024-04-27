package com.aluracursos.currencyconverter.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Manuel Aguilera
 */
public class ApiConnector {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/a3eccac6f0950c9540295ef9/latest/";
    private static String responseBody;

    public static String apiRequest(String baseCode){
        String url = API_URL+baseCode;

       try {
           HttpRequest request = HttpRequest
                   .newBuilder()
                   .uri(URI.create(url))
                   .build();

           HttpClient client = HttpClient.newBuilder().build();

           CompletableFuture<String> response =
                   client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);

           setResponseBody(response.get());

       }catch (InterruptedException | ExecutionException e){
           System.out.println("Ha ocurrido un error al realizar la peticion HTTP");
           e.getMessage();
       }

        return getResponseBody();

    }

    public static String getResponseBody() {
        return responseBody;
    }

    private static void setResponseBody(String responseBody) {
        ApiConnector.responseBody = responseBody;
    }
}
