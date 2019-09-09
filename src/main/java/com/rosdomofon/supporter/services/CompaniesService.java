package com.rosdomofon.supporter.services;

import com.rosdomofon.supporter.entity.Company;
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

public class CompaniesService {
    private List<Company> companies = new ArrayList<>();

    public CompaniesService() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://rdba.rosdomofon.com/companies-service/api/v1/companies");
        Authorization authorization = Authorization.getAuthorization();
        get.addHeader("Authorization", "Bearer " + authorization.getProducerAccessToken());
        try {
            HttpResponse response = client.execute(get);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            try {
                JSONArray jsonArray = (JSONArray) new JSONParser().parse(rd);
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    Company company = new Company();
                    company.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    company.setName(jsonObject.get("name").toString());
                    companies.add(company);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
