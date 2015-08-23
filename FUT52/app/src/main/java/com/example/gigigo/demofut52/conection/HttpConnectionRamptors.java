package com.example.gigigo.demofut52.conection;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by principal on 29/06/15.
 */
public class HttpConnectionRamptors {

    public static String getResponseRamptorsHttp(String URL) {
        String URL_ALL_TEAMS = URL;

        String CODE = "";
        HttpURLConnection urlConnection = null;
       // String postParameters = "grant_type=password&username=" + username + "&password=" + password + "";
        try {
            // create connection
            URL urlToRequest = new URL(URL_ALL_TEAMS);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(10000);
            //urlConnection.setReadTimeout(CONNECTION_TIMEOUT);

            // handle POST parameters
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");

            //send the POST out
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
           // out.print(postParameters);
            out.close();


            // handle issues
            int statusCode = urlConnection.getResponseCode();
              Log.e("status",statusCode+"");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                CODE = getStringFromInputStream(in);



        } catch (MalformedURLException e) {
            // handle invalid URL
        } catch (SocketTimeoutException e) {
            // hadle timeout
            CODE= null;
        } catch (IOException e) {
            // handle I/0
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return CODE;
    }



    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
