package PhoneCode.controller;


import PhoneCode.service.GetMapFromWebPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@AllArgsConstructor

public class Controller {

    private final GetMapFromWebPage getMapFromWebPage;


    @GetMapping({"/listCodes"})

    public Map<String, String> getMap() throws IOException {

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

        return getMapFromWebPage.getDataFromPage(url);
    }



}
