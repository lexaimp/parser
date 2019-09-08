package com.rosdomofon.supporter.services;

import com.rosdomofon.supporter.entity.Address;
import com.rosdomofon.supporter.entity.Camera;
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

public class CamerasService {
    private List<Camera> cameras = new ArrayList<>();

    public CamerasService() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://rdba.rosdomofon.com/cameras-service/api/v1/cameras");
        Authorization authorization = Authorization.getAuthorization();
        get.addHeader("Authorization", "Bearer " + authorization.getAccessToken());
        try {
            HttpResponse response = client.execute(get);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            try {
                JSONArray jsonArray = (JSONArray) new JSONParser().parse(rd);
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    Camera camera = new Camera();
                    camera.setId(Integer.parseInt(jsonObject.get("uid").toString()));
                    camera.setUrl(jsonObject.get("uri").toString());

                    if (jsonObject.get("password") != null) {
                        camera.setPassword(jsonObject.get("password").toString());
                    }
                    if (jsonObject.get("user") != null) {
                        camera.setUser(jsonObject.get("user").toString());
                    }
                    camera.setPrivate(Boolean.getBoolean(jsonObject.get("private").toString()));

                    Address address = new Address();
                    JSONObject jAddress = (JSONObject) jsonObject.get("address");
                    address.setCity(jAddress.get("city").toString());

                    JSONObject jStreet = (JSONObject) jAddress.get("street");
                    address.setStreet(jStreet.get("name").toString());

                    JSONObject jHouse = (JSONObject) jAddress.get("house");
                    address.setHouse(jHouse.get("number").toString());

                    JSONObject jEntrance = (JSONObject) jAddress.get("entrance");
                    address.setEntrance(jEntrance.get("number").toString());


                    camera.setAddress(address);
                    cameras.add(camera);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Camera> getCameras() {
        return cameras;
    }
}
