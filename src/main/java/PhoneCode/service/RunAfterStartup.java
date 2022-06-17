package PhoneCode.service;

import org.jsoup.nodes.Document;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


public class RunAfterStartup {

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("Application is running........");

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

       //Document doc = getDataFromPage(url);



    }
}