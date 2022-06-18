package PhoneCode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class CodesMap {

        public static void main(String[] args) throws IOException {
            Document document =
                    Jsoup.connect(
                            "https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
            Element table = document.select("table.wikitable").get(1);
            Elements body = table.select("tbody");
            Elements rows = body.select("tr");

            Map<String, String> codes =
                    new HashMap<>();
            for (Element row : rows) {
                Elements columns = row.select("td");
                if (columns.size() > 2) {
                    String name = columns.get(0).text();
                    String code = columns.get(1).text();
                    codes.put( code,name);
                }
            }
            codes.forEach((n,c) -> System.out.println(n + " -> " + c));
        }


}
