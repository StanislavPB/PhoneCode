package PhoneCode.core;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class CreateCodeList {
        private final ModificationCodeList modificationCodeList;
    private final TakeCodeListFromPage takeCodeListFromPage;

    public List<String> createCodeList (Document doc) {

        List<String> codeList = takeCodeListFromPage.takeCodeList(doc);
        List<String> modifyCodeList = new ArrayList<>();


        for (int i = 0; i < codeList.size(); i++) {

            String modifiedLine = modificationCodeList.modificationList(codeList.get(i));

            if (modifiedLine != " ") {
                modifyCodeList.add(modifiedLine);
            }

        }

            return modifyCodeList;
        }


}

