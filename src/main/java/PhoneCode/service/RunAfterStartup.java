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

    private final Browser browser;


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws IOException {


        System.out.println("Application is running........");


        browser.browser("http://localhost:8080/listCodes/");







    }
}