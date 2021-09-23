package com.packtpub.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Activity01 {
    public static void main(String[] args) {
        String path = "http://hc.apache.org/";
        try {
            Document doc = Jsoup.connect(path).get();
            Elements components = doc.select("div main section section h3");
            for (Element comp: components)
            {
                String text = comp.text();
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
