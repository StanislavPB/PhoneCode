package PhoneCode.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Service
public class GetMapFromWebPage {

    public Map<String, String> getDataFromPage(String url) throws IOException{

        Document document =
                Jsoup.connect(
                        "https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = document.select("table.wikitable").get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");

        Map<String, String> codesMap =
                new HashMap<>();
        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text();
                codesMap.put( code,name);
            }
        }

        return codesMap;
    }


}

