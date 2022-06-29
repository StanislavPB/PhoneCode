package PhoneCode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhoneCodeDetectorApp {



    public static void main(String[] args) {
        try {
            SpringApplication.run(PhoneCodeDetectorApp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

