package PhoneCode.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class CreateCodeList {
        private  final ModificationCodeList modificationCodeList;
        private final List<String> codeList = new ArrayList<>();
        private final  List<String> modifyCodeList = new ArrayList<>();


    public List<String> createCodeList (Document doc){

        Elements links = doc.select("li");


        for (Element link : links) {

                Elements bodies = link.select("li");
                String body = bodies.text();

                if (body.contains("+")) {
                    codeList.add(body);
                }
        }

            for (int i = 0; i < codeList.size(); i++) {

                String modifiedLine = modificationCodeList.modificationList(codeList.get(i));

                if (modifiedLine != " ") {
                    modifyCodeList.add(modifiedLine);
                }

            }

            return modifyCodeList;
        }


}

