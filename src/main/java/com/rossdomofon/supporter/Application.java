package com.rossdomofon.supporter;

import com.rossdomofon.supporter.Cameras.RdvaParser;

public class Application {
    public static void main(String[] args) {
        RdvaParser rdvaParser = new RdvaParser("rdva");
        System.out.println(rdvaParser.partseHtml());
    }
}
