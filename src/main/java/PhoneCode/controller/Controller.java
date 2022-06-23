package PhoneCode.controller;


import PhoneCode.service.DetectCountry;
import PhoneCode.service.GetMapFromWebPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("codes")

public class Controller {

    private final GetMapFromWebPage getMapFromWebPage;

    private final DetectCountry detectCountry;


    @GetMapping

    public Map<String, String> getMap() throws IOException {

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

        var codeList=getMapFromWebPage.getDataFromPage(url);

        return codeList;
    }

    @PostMapping
    public List<Map<String, String>> checkCountry (@RequestBody String phoneNumber) throws IOException {

        System.out.println(phoneNumber);
        String countryArea = "+"+phoneNumber.substring(0, (phoneNumber.length()-7));

        List<Map<String, String>> country =  detectCountry.getCountry(countryArea);

        System.out.println(phoneNumber +" -> "+country.toString());


        return country;
    }



}
