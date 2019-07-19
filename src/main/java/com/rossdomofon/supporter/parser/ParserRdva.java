package com.rossdomofon.supporter.parser;

import com.rossdomofon.supporter.entity.Camera;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ParserRdva {
    URL url;
    Document html;

    public ParserRdva(String rdva) {
        try {
            url = new URL("http://" + rdva + ".rosdomofon.com:2205/sysinfo/sources");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Camera> parseHtml() {
        try {
            html = Jsoup.parse(url, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Camera> cameras = new ArrayList<Camera>(100);

        Elements listElements = html.body().getElementsByTag("tr");
        listElements.remove(0);

        for (Element e : listElements) {
            Camera camera = new Camera();
            camera.setId(Integer.parseInt(e.child(0).text()));
            camera.setBitRate(Double.parseDouble(e.child(2).text()));

            cameras.add(camera);
        }
        return cameras;
    }


}
