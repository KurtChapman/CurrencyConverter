package com.kurt.demoapp.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kurt on 17/01/2017.
 */

public final class Utils {
    public static String getStringFromInputStream(InputStream stream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        StringBuilder finalString = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            finalString.append(line).append('\n');
        }
        return finalString.toString();
    }
}
