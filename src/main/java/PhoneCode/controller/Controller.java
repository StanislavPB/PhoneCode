package PhoneCode.controller;


import PhoneCode.core.CreateCodeList;
import PhoneCode.service.GetPageFromWeb;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class Controller {

    private final GetPageFromWeb getPageFromWeb;
    private final CreateCodeList createCodeList;

    @GetMapping({"/listCodes"})

    public List<String> findAll() throws IOException {

        List<String> finalCodeList = new ArrayList<>();

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";


        Document doc = getPageFromWeb.getDataFromPage(url);

        finalCodeList = createCodeList.createCodeList(doc);

        return finalCodeList;
    }


}
