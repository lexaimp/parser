package com.rosdomofon.supporter.parser;

import com.rosdomofon.supporter.entity.Camera;
import com.rosdomofon.supporter.entity.Rdva;
import com.rosdomofon.supporter.services.CamerasService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RdvaParser {
    private URL[] url;
    private List<Camera> cameras = new CamerasService().getCameras();

    public RdvaParser(List<Rdva> rdvas) {
        url = new URL[rdvas.size()];
        for (int i = 0; i < url.length; i++) {
            try {
                url[i] = new URL("http://" + rdvas.get(i).getUri() + ":2205/sysinfo/sources");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Camera> parseHtml() {
        Document html = null;
        for (URL u : url) {
            try {
                html = Jsoup.parse(u, 1000);
            } catch (IOException e) {
                e.printStackTrace();
            }


            Elements listElements = html.body().getElementsByTag("tr");
            listElements.remove(0);

            for (Element e : listElements) {
                Integer cameraId = Integer.parseInt(e.child(0).text());
                Optional<Camera> optionalCamera = cameras.stream().filter(x -> x.getId().equals(cameraId)).findFirst();
                optionalCamera.ifPresent(camera -> camera.setBitRate(Double.parseDouble(e.child(5).text())));
            }
        }
        return cameras;
    }

    public List<Camera> filterByHighBitRate(List<Camera> cameras, Double bitRate) {
        return cameras.stream().filter(x -> x.getBitRate() > bitRate).sorted(Comparator.comparingInt(Camera::getId)).collect(Collectors.toList());
    }
}
