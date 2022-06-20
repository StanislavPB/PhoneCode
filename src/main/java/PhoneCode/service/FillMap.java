package PhoneCode.service;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class FillMap {

    public Map<String, String> fillMap(Elements rows) {

        Map<String, String> codesMap = new HashMap<>();

        for (Element row : rows) {
            Elements columns = row.select("td");

            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text();

                String[] arrOfStr = code.split(",");;

                for (String a : arrOfStr) {
                    if (a.contains("[")) {  a = a.substring(0,a.indexOf("["));}
                    if (a.charAt(0)=='+') {codesMap.put( a.trim(),name);}
                }
            }
        }
        return codesMap;
    }
}

