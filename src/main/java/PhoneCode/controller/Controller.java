package PhoneCode.controller;


import PhoneCode.service.DetectCountry;
import PhoneCode.service.GetMapFromWebPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("codes")

public class Controller {
    private final DetectCountry detectCountry;

    private List <String> messages;

    @GetMapping

    public List< String> list() {
        return messages;
    }

    @PostMapping
    public List<String> checkCountry (@RequestBody String phoneNumber) throws IOException {

        messages.clear();

        String countryArea = "+"+phoneNumber.substring(0, (phoneNumber.length()-7));

        Map<String, String> country =  detectCountry.getCountry(countryArea);


        for (Map.Entry entry : country.entrySet()) {

            System.out.println("Detected->"+entry.getValue()+" "+ entry.getKey());
            String message="Your phone number - "+ phoneNumber+ "  Country code - " + entry.getKey()
                    + "  Country is "+ entry.getValue();

            messages.add(message);
        }

        System.out.println("return: "+ messages.toString());


        return messages;
    }

}
