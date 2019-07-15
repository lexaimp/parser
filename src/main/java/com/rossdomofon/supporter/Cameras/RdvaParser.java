package com.rossdomofon.supporter.Cameras;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RdvaParser {
    URL url;
    Document html;

    public RdvaParser(String rdva) {
        try {
            url = new URL("http://" + rdva + ".rosdomofon.com:2205/sysinfo/sources");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String partseHtml() {
        try {
            html = Jsoup.parse(url, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements listElements = html.body().getElementsByTag("tr");
        for (Element e : listElements) {
            for (int i = 0; i < e.childNodeSize(); i++) {
                System.out.println(e.getElementsByIndexEquals(i).text());
            }
        }
return null;
//        return listElements.get(2).getElementsByIndexEquals(0).text();
    }
}
