package PhoneCode.core;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




public class TakeCodeListFromPage {

    /* public List<String> takeCodeList(Document doc) {

        List<String> codeList = new ArrayList<>();

        Elements links = doc.select("li");


        for (Element link : links) {

            Elements bodies = link.select("li");
            String body = bodies.text();

            if (body.contains("+")) {
                codeList.add(body);
            }
        }

        return codeList;
    }

     */

}

