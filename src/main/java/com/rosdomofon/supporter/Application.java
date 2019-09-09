package com.rosdomofon.supporter;

import com.rosdomofon.supporter.entity.Camera;
import com.rosdomofon.supporter.parser.RdvaParser;
import com.rosdomofon.supporter.services.CompaniesService;
import com.rosdomofon.supporter.services.RdvasService;

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
