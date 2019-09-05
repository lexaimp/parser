package com.rosdomofon.supporter.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Authorization {
    private static Authorization authorization;
    private String AccessToken = getAccessTokenFromAPI();

    private Authorization() {
    }

    public static Authorization getAuthorization() {
        if (authorization == null) {
            authorization = new Authorization();
        }
        return authorization;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    private static String getAccessTokenFromAPI() {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://rdba.rosdomofon.com/authserver-service/oauth/token");
        List<BasicNameValuePair> nameValuePairs = new ArrayList<>(4);
        nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
        nameValuePairs.add(new BasicNameValuePair("client_id", "machine"));
        nameValuePairs.add(new BasicNameValuePair("username", ""));
        nameValuePairs.add(new BasicNameValuePair("password", ""));
        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            try {
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(rd);
                return jsonObject.get("access_token").toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
