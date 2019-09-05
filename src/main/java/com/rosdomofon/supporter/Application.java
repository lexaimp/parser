package com.rosdomofon.supporter;

import com.rosdomofon.supporter.entity.Camera;
import com.rosdomofon.supporter.parser.RdvaParser;
import com.rosdomofon.supporter.rest.Authorization;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        RdvaParser rdvaParser = new RdvaParser("rdva");
        ArrayList<Camera> listCameras = rdvaParser.parseHtml().stream()
                .filter(camera -> camera.getBitRate() > 1100)
                .collect(Collectors.toCollection(ArrayList::new));
        listCameras.forEach((camera -> System.out.print(camera.getId() + ", ")));
        System.out.println(Authorization.getAuthorization().getAccessToken());
    }
}
