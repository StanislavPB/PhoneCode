package PhoneCode.controller;


import PhoneCode.service.GetMapFromWebPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("codes")

public class Controller {

    private final GetMapFromWebPage getMapFromWebPage;


    @GetMapping

    public Map<String, String> getMap() throws IOException {

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

        var codeList=getMapFromWebPage.getDataFromPage(url);

        return codeList;
    }

    @PostMapping
    public String checkCountry (@RequestBody String phoneNumber){

        String countryArea = "+"+phoneNumber.substring(0, (phoneNumber.length()-7));
        return countryArea;
    }



}
