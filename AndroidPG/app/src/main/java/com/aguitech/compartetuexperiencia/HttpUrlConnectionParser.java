package com.aguitech.compartetuexperiencia;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hectoraguilar on 15/01/16.
 */
public class HttpUrlConnectionParser {
    public static JSONObject jObj = null;
    public static InputStream is = null;
    public static String json = "";
    public static HttpURLConnection urlConnection;

    public HttpUrlConnectionParser(){

    }
    public static JSONObject makehttpUrlConnection(String urlPath, HashMap<String, String> data){
        try{
            URL url = new URL(urlPath);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(150000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            OutputStream os = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQueryData(data));
            writer.flush();
            writer.close();
            urlConnection.connect();
            is = urlConnection.getInputStream();





        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line+"\n");
            }
            json = sb.toString();
            is.close();
        }catch(UnsupportedOperationException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            jObj = new JSONObject(json);
        }catch(JSONException e){
            e.printStackTrace();
        }

        return jObj;

    }

    public static String getQueryData(HashMap<String, String> data) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for(Map.Entry<String,String> entry:data.entrySet()){
            if(first)
                first=false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));

        }
        return result.toString();
    }

}
