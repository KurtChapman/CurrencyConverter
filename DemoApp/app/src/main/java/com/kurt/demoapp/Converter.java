package com.kurt.demoapp;

import com.kurt.demoapp.AsyncHttpClient.Request;
import com.kurt.demoapp.AsyncHttpClient.Response;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.net.URL;

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

    public int getConvertedCurrency(int amount, String from, String to) throws ExecutionException, InterruptedException, MalformedURLException {
        String requestUrl = generateRequest(from, to);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Response> response = executor.submit(new Request(new URL(requestUrl)));
        InputStream body = response.get().getBody();
        executor.shutdown();

        return 0;
    }
}
