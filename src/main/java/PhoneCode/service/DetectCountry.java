package PhoneCode.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class DetectCountry {

    private final GetMapFromWebPage getMapFromWebPage;

    public List<String> getCountry(String codeForCheck) throws IOException {

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

        var codeList = getMapFromWebPage.getDataFromPage(url);

        List<String> countryList = new ArrayList<>();

        for (Map.Entry<String,String> entry : codeList.entrySet()) {


            System.out.println(entry.getKey()+" -> "+entry.getValue());

            String codeForCheck2= codeForCheck.substring(0,codeForCheck.length()-2);
            String codeForCheck3= codeForCheck.substring(0,codeForCheck.length()-3);

            if (Objects.equals(entry.getKey(), codeForCheck)){
                countryList.add(entry.getValue());
            }
            if (Objects.equals(entry.getKey(), codeForCheck2)){
                countryList.add(entry.getValue());
            }
            if (Objects.equals(entry.getKey(), codeForCheck3)){
                countryList.add(entry.getValue());
            }
        }

        System.out.println(countryList.toString());

        return countryList;
    }
}