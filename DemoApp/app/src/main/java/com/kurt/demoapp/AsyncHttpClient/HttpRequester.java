package com.kurt.demoapp.AsyncHttpClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kurt on 17/01/2017.
 */

public class HttpRequester {
    private String requestUrl;

    public HttpRequester(String requestUrl){
        this.requestUrl = requestUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public Future<Response> makeRequest() throws ExecutionException, InterruptedException, MalformedURLException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Response> response = executor.submit(new Request(new URL(requestUrl)));
        executor.shutdown();
        return response;
    }

}
