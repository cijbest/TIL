package com.example.p500;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnect {

    public static String getString(String urlstr) {
        String result = null;
        URL url = null;
        HttpURLConnection hcon = null;
        InputStream is = null;
        try {
            url = new URL(urlstr);
            hcon = (HttpURLConnection) url.openConnection();
            hcon.setConnectTimeout(2000);
            hcon.setRequestMethod("GET");
            is = new BufferedInputStream(hcon.getInputStream());
            result = convertStr(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String convertStr(InputStream is) {
        String result = null;
        BufferedReader bi = null;
        StringBuilder sb = new StringBuilder();
        try {
            bi = new BufferedReader(
                    new InputStreamReader(is)
            );
            String temp = "";
            while ((temp = bi.readLine()) != null) {
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
