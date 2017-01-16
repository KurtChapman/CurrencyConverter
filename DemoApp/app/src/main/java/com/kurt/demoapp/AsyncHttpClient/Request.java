package com.kurt.demoapp.AsyncHttpClient;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Created by kurt on 16/01/2017.
 */

public class Request implements Callable<Response> {
    private URL url;

    public Request(URL url) {
        this.url = url;
    }

    @Override
    public Response call() throws Exception {

        return new Response(url.openStream());
    }
}
