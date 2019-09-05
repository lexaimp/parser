package com.rossdomofon.supporter;

import com.rossdomofon.supporter.entity.Camera;
import com.rossdomofon.supporter.parser.RdvaParser;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        RdvaParser rdvaParser = new RdvaParser("rdva");
        ArrayList<Camera> listCameras = rdvaParser.parseHtml().stream()
                .filter(camera -> camera.getBitRate() > 1100)
                .collect(Collectors.toCollection(ArrayList::new));
        listCameras.forEach((camera -> System.out.print(camera.getId() + ", ")));
    }
}
