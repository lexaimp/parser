package com.rossdomofon.supporter;

import com.rossdomofon.supporter.parser.ParserRdva;

public class Application {
    public static void main(String[] args) {
        ParserRdva parserRdva = new ParserRdva("rdva");
        System.out.println(parserRdva.parseHtml().get(2).getId());
    }
}
