package com.rosdomofon.supportive;

import com.rosdomofon.supportive.entity.Camera;
import com.rosdomofon.supportive.parser.RdvaParser;
import com.rosdomofon.supportive.services.CompaniesService;
import com.rosdomofon.supportive.services.RdvasService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RdvaParser rdvaParser = new RdvaParser(new RdvasService().getRdvas());
        List<Camera> cameras = rdvaParser.parseHtml();
        cameras = rdvaParser.filterByHighBitRate(cameras, 1100.0);
        System.out.println(cameras.toString());
        System.out.println((long) cameras.size());

        CompaniesService companiesService = new CompaniesService();
        companiesService.getCompanies().forEach(x -> System.out.println(x.getName()));
    }
}
