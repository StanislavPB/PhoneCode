package PhoneCode.service;

import org.springframework.stereotype.Service;


import java.io.IOException;



@Service
public class Browser {
    public static void browser(String urlApp) throws IOException {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") >= 0) {Runtime rt = Runtime.getRuntime();
            rt.exec("rundll32 url.dll,FileProtocolHandler " + urlApp);}

        if (os.indexOf("mac") >= 0) {

            Runtime rt = Runtime.getRuntime();

            rt.exec("open " + urlApp);

        }
    }
}