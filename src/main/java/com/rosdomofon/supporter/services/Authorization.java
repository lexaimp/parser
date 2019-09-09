package com.rosdomofon.supporter.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
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

class Authorization {
    private static Authorization authorization;
    private String accessToken = null;
    private String producerAccessToken = null;
    private static final Object lock = new Object();

    private Authorization() {
        HttpClient client = HttpClientBuilder.create().build();
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
                accessToken = jsonObject.get("access_token").toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     static Authorization getAuthorization() {
        if (authorization == null) {
            synchronized (lock) {
                if (authorization == null) {
                    authorization = new Authorization();
                }
            }
        }
        return authorization;
    }

     String getAccessToken() {
        return accessToken;
    }

    public String getProducerAccessToken() {
        HttpClient client = HttpClientBuilder.create().build();
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
                producerAccessToken = jsonObject.get("access_token").toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return producerAccessToken;
    }
}
