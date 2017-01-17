package com.kurt.demoapp;

import com.kurt.demoapp.AsyncHttpClient.HttpRequester;
import com.kurt.demoapp.AsyncHttpClient.Response;
import com.kurt.demoapp.Utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kurt on 16/01/2017.
 */

public class Converter {

    String requestString = "http://finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s=%s=X";

    public Converter(){

    }

    private String generateRequest(String from, String to){
        StringBuilder countryCodes = new StringBuilder(from);
        countryCodes.append(to);
        String request = String.format(requestString, countryCodes);
        return request;
    }

    public float getConvertedCurrencyRate(String from, String to) throws InterruptedException, ExecutionException, IOException {
        String requestString = generateRequest(from, to);
        HttpRequester requester = new HttpRequester(requestString);
        Future<Response> response = requester.makeRequest();
        String completeCSV = handleResponse(response);
        float rate = extractCurrencyRateFromCSV(completeCSV);
        return rate;
    }

    private String handleResponse(Future<Response> response) throws ExecutionException, InterruptedException, IOException {
        Response r = response.get();
        InputStream responseBody = r.getBody();
        return Utils.getStringFromInputStream(responseBody);
    }

    private float extractCurrencyRateFromCSV(String csv){
        List<String> splitCsv =  Arrays.asList(csv.split(","));
        float rate = Float.parseFloat(splitCsv.get(1));
        return rate;
    }
}
