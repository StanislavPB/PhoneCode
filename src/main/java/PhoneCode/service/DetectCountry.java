package PhoneCode.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class DetectCountry {

    private final GetMapFromWebPage getMapFromWebPage;

    public List<Map<String, String>> getCountry(String codeForCheck) throws IOException {

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

        var codeList = getMapFromWebPage.getDataFromPage(url);

        List<Map<String, String>> countryList = new ArrayList<Map<String, String>>();

        for (Map.Entry<String,String> entry : codeList.entrySet()) {


            System.out.println(entry.getKey()+" -> "+entry.getValue());

            String codeForCheck1= codeForCheck.substring(0,codeForCheck.length()-1);
            String codeForCheck2= codeForCheck.substring(0,codeForCheck.length()-2);
            String codeForCheck3= codeForCheck.substring(0,codeForCheck.length()-3);

            if (Objects.equals(entry.getKey(), codeForCheck)){
                countryList.add(new HashMap<String,String>() {{put("phone",codeForCheck); put("country",entry.getValue());}});
               }
            if (Objects.equals(entry.getKey(), codeForCheck1)){
                countryList.add(new HashMap<String,String>() {{put("phone",codeForCheck1); put("country",entry.getValue());}});
            }
            if (Objects.equals(entry.getKey(), codeForCheck2)){
                countryList.add(new HashMap<String,String>() {{put("phone",codeForCheck2); put("country",entry.getValue());}});

            }
            if (Objects.equals(entry.getKey(), codeForCheck3)){
                countryList.add(new HashMap<String,String>() {{put("phone",codeForCheck3); put("country",entry.getValue());}});

            }

            System.out.println(codeForCheck +" " + codeForCheck1 +" " + codeForCheck2 +" " + codeForCheck3 +" " + countryList.toString());

        }

        return countryList;
    }
}