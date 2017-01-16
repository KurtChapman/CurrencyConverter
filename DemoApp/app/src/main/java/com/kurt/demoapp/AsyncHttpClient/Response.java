package com.kurt.demoapp.AsyncHttpClient;

import java.io.InputStream;

/**
 * Created by kurt on 16/01/2017.
 */

public class Response {
    private InputStream body;

    public Response(InputStream body) {
        this.body = body;
    }

    public InputStream getBody() {
        return body;
    }
}
