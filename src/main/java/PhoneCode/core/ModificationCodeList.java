package PhoneCode.core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ModificationCodeList {

    public String modificationList(String line) {
        String modifiedLine = " ";

        if (line.contains("–")) {
            modifiedLine = line;
        }

        if (modifiedLine.contains(" +")) {
            int index1 = modifiedLine.indexOf(" +");
            modifiedLine = modifiedLine.substring(0, index1);
        }

        if (modifiedLine.contains(",")) {
            int index3 = modifiedLine.indexOf(",");
            modifiedLine = modifiedLine.substring(0, index3);
        }

        if (modifiedLine.contains("(")) {
            int index2 = modifiedLine.indexOf("(");
            modifiedLine = modifiedLine.substring(0, index2);
        }

        if (modifiedLine.contains(" Many")) {
            modifiedLine = " ";
        }
        if (modifiedLine.contains("^ a b")) {
            modifiedLine = " ";
        }
        if (modifiedLine.contains("Phone calling")) {
            modifiedLine = " ";
        }

        return modifiedLine;
    }
}
