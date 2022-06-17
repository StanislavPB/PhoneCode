package PhoneCode.service;

import PhoneCode.core.CreateCodeList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@AllArgsConstructor

public class RunAfterStartup {

    private final GetPageFromWeb getPageFromWeb;
    private final CreateCodeList createCodeList;


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws IOException {

        List<String> finalCodeList = new ArrayList<>();

        System.out.println("Application is running........");

        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";


        Document doc = getPageFromWeb.getDataFromPage(url);

        finalCodeList = createCodeList.createCodeList(doc);







    }
}