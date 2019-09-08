package com.rosdomofon.supporter.services;

import com.rosdomofon.supporter.entity.Rdva;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RdvasService {
    private List<Rdva> rdvas = new ArrayList<>();

    public RdvasService() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://rdba.rosdomofon.com/cameras-service/api/v1/rdvas");
        Authorization authorization = Authorization.getAuthorization();
        get.addHeader("Authorization", "Bearer " + authorization.getAccessToken());
        try {
            HttpResponse response = client.execute(get);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            try {
                JSONArray jsonArray = (JSONArray) new JSONParser().parse(rd);
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    Rdva rdva = new Rdva();
                    rdva.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    rdva.setUid(jsonObject.get("uid").toString());
                    rdva.setUri(jsonObject.get("uri").toString());
                    rdva.setDescription(jsonObject.get("description").toString());

                    rdvas.add(rdva);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Rdva> getRdvas() {
        return rdvas;
    }
}
