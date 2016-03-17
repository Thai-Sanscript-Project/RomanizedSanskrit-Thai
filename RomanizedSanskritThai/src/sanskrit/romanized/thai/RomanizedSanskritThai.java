package sanskrit.romanized.thai;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanakrit.P
 */
public class RomanizedSanskritThai {

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        //String romaSanskritTxt = fileUtil.getFile("sample.txt");

        ThaiCharacterRule rule = new ThaiCharacterRule();
        List<String> listLine = fileUtil.getListLine("sample.txt");
        List<String> listLineThai = new ArrayList<>();
        for (String line : listLine) {
            line = line.toLowerCase();
            String[] syllableThai = line.split(" ");
            String[] syllableRoman = line.split(" ");

            StringBuilder builderThai = new StringBuilder();
            StringBuilder builderRoman = new StringBuilder();
            for (int i = 0; i < syllableThai.length; i++) {
                syllableThai[i] = rule.convert(syllableThai[i]);
                builderThai.append(syllableThai[i]);
                builderThai.append(" ");
                builderRoman.append(syllableRoman[i]);
                builderRoman.append(" ");
            }

            listLineThai.add(builderThai.toString());
            listLineThai.add("\n");
            listLineThai.add(builderRoman.toString());
            listLineThai.add("\n");

        }

        System.out.print(rule.convertListTostring(listLineThai));
        System.out.print("");
    }

}
