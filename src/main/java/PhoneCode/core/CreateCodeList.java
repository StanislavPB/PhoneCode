package PhoneCode.core;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreateCodeList {


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

            String modifiedLine = modificationCodeList(codeList.get(i));

            if  (modifiedLine != " ") {modifyCodeList.add(modifiedLine);}

        }


        for (int i = 0; i < modifyCodeList.size(); i++) {

            System.out.println(modifyCodeList.get(i));

        }


            return null;
        }


    public static String modificationCodeList(String line) {
        String modifiedLine=" ";

        //System.out.println("line -> "+line);

        if (line.contains("–")) {modifiedLine=line;}


        if (modifiedLine.contains(" +")) {
            int index1= modifiedLine.indexOf(" +");
            modifiedLine=modifiedLine.substring(0,index1);}

        if (modifiedLine.contains(",")) {
            int index3= modifiedLine.indexOf(",");
            modifiedLine=modifiedLine.substring(0,index3);}

        if (modifiedLine.contains("(")) {
            int index2= modifiedLine.indexOf("(");
            modifiedLine=modifiedLine.substring(0,index2);}



        if (modifiedLine.contains(" Many")) {modifiedLine = " ";}
        if (modifiedLine.contains("^ a b")) {modifiedLine = " ";}
        if (modifiedLine.contains("Phone calling")) {modifiedLine = " ";}



        //System.out.println("modified line ->"+modifiedLine);

        return modifiedLine;
    }
}

