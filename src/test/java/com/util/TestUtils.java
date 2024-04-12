package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class TestUtils {
    public static String getTestArg(String path) {
        String s = new JSONReader(
            new BufferedReader(new InputStreamReader(TestUtils.class.getResourceAsStream(path))))
            .readString();
        return s;
    }
}