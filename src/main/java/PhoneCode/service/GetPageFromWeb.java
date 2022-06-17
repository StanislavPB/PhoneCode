package PhoneCode.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;


@Service
public class GetPageFromWeb {

    public Document getDataFromPage(String url) throws IOException{

        Document page = Jsoup.parse(new URL(url),3000);

        return page;
    }


}

