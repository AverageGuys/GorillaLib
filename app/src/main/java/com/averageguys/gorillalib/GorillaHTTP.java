/*
 * DESCRIPTION: 		Android Generic Libraries
 * AUTHOR: 				Marcial Paul Juztin Sagmit
 * 						Omar Matthew Reyes

 * DATE CREATED:		June 4, 2014
 * DATE LAST UPDATED:	March 25, 2015
 *
 * TIME CREATED:		10:00 AM
 *
 * Version: 1.0.1
 *
 */

package com.averageguys.gorillalib;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaHTTP {
    public static final String ERRMSG = "<ERRSTAT>ERROR</ERRSTAT>";

    public static String getHttpResponse(String url, HttpEntity entity) {

        String result = "";
        String BOUNDARY = "ARCFormBoundary2cf4nvz3ult0529";
        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost(url);
            // httppost.setHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            httppost.setEntity(entity);

            HttpResponse httpResponse = httpclient.execute(httppost);

            HttpEntity httpEntity = httpResponse.getEntity();

            result = EntityUtils.toString(httpEntity);

            Log.e("HTTP RESP:", result);

        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            Log.i("ERR1", e.getMessage());
            result = "<ERR><ERRSTAT>ERROR</ERRSTAT><ERRMSG>" + e.getMessage() + "</ERRMSG></ERR>";
        } catch (ClientProtocolException e) {
            //e.printStackTrace();
            Log.i("ERR2", e.getMessage());
            result = "<ERR><ERRSTAT>ERROR</ERRSTAT><ERRMSG>" + e.getMessage() + "</ERRMSG></ERR>";
        } catch (IOException e) {
            //e.printStackTrace();
            Log.i("ERR3", e.getMessage());
            result = "<ERR><ERRSTAT>ERROR</ERRSTAT><ERRMSG>" + e.getMessage() + "</ERRMSG></ERR>";
        }

        return result;

    }


    public static String getHttpResponse(String url, String json) {

        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost(url);
            httppost.setHeader("Content-Type", "application/json");
            httppost.setHeader("Authorization", "Basic dXNlcjpwYXNz");

            StringEntity se = new StringEntity(json);

            httppost.setEntity(se);

            HttpResponse httpResponse = httpclient.execute(httppost);

            HttpEntity httpEntity = httpResponse.getEntity();

            result = EntityUtils.toString(httpEntity);

            Log.e("HTTP RESP JSON PARAM:", result);

        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            Log.i("ERR1", "" + e.getMessage());
            result = "false";
        } catch (ClientProtocolException e) {
            //e.printStackTrace();
            Log.i("ERR2", "" + e.getMessage());
            result = "false";
        } catch (IOException e) {
            //e.printStackTrace();
            Log.i("ERR3", "" + e.getMessage());
            result = "false";
        }

        return result;

    }
}
