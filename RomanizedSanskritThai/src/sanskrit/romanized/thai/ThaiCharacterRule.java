/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanskrit.romanized.thai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thanakrit.P
 */
public class ThaiCharacterRule {

    public String convert(String romanize) {
        return convert(romanize, false);
    }
    public String convertTrackMode(String romanize) {
        return convert(romanize, true);
    }

    public String convert(String romanize, Boolean isTracking) {

        printTrackMode(romanize, isTracking);

        romanize = convertRomanizeMixConsonant(romanize);
        printTrackMode(romanize, isTracking);
        romanize = convertRomanizeMixVowel(romanize);
        printTrackMode(romanize, isTracking);

        romanize = convertRomanizeSingleConsonant(romanize);
        printTrackMode(romanize, isTracking);

        romanize = convertRomanizeSingleVowel(romanize);
        printTrackMode(romanize, isTracking);

        romanize = convertThaiVowelInFist(romanize);
        printTrackMode(romanize, isTracking);

        String thaiChar = romanize;
       
        thaiChar = convertThaiVisarga(thaiChar);
        printTrackMode(thaiChar, isTracking);
       
        thaiChar = convertThaiVowelPrefix(thaiChar);
        printTrackMode(thaiChar, isTracking);

        return thaiChar;
    }

    public void printTrackMode(String romanize, Boolean isTracking) {

        if (isTracking) {
            System.out.print(romanize+" -> ");         
        }
    }

    public String convertRomanizeSingleConsonant(String romanize) {
        Map<String, String> mapping = MappingCharacter.mappingSingleConsonant();
        return Mapper(mapping, romanize);
    }

    public String convertRomanizeMixConsonant(String romanize) {
        Map<String, String> mapping = MappingCharacter.mappingMixConsonant();
        return Mapper(mapping, romanize);
    }

    public String convertRomanizeSingleVowel(String romanize) {
        Map<String, String> mapping = MappingCharacter.mappingSingleVowel();
        return Mapper(mapping, romanize);
    }

    public String convertRomanizeMixVowel(String romanize) {
        Map<String, String> mapping = MappingCharacter.mappingMixVowel();
        return Mapper(mapping, romanize);
    }

    public String convertThaiVowelInFist(String thaiChar) {
        Map<String, String> mapping = MappingCharacter.mappingThaiVowelInFist();
        if (thaiChar.length() > 0) {
            for (Map.Entry<String, String> entrySet : mapping.entrySet()) {
                String key = entrySet.getKey();
                String value = entrySet.getValue();
                //char[] fist = romanize.toCharArray();
                if (thaiChar.charAt(0) == key.charAt(0)) {
                    thaiChar = thaiChar.substring(1);
                    thaiChar = value + thaiChar;

                }

                List<String> charList = charList(thaiChar);

                for (int i = 0; i < charList.size(); i++) {
                    if (i > 0) {
                        boolean check1 = !isThaiConsonant(charList.get(i - 1));
                        boolean check2 = charList.get(i).equals(key);
                        if (check1 && check2) {
                            charList.set(i, value);
                        }
                    }

                }

                thaiChar = convertListTostring(charList);
            }
        }

        return thaiChar;
    }

    public String convertThaiVisarga(String thaiChar) {
        thaiChar = " " + thaiChar + "  ";
        List<String> charList = charList(thaiChar);

        for (int i = 0; i < charList.size(); i++) {
            boolean check = charList.get(i).equals("ะ");

            if (check) {

                String beforeA = charList.get(i - 1);
                String currentA = charList.get(i);
                String afterA1 = charList.get(i + 1);
                String afterA2 = charList.get(i + 2);

                if (beforeA.equals(" ") && charList.get(i).equals("ะ")) {
                    charList.set(i, "อั");
                }

                if ((isThaiConsonant(afterA1) && isThaiConsonant(afterA2)) && charList.get(i).equals("ะ") && !afterA2.equals("ร") ) {
                    charList.set(i, "ั");
                }

                if ((isThaiConsonant(afterA1) && !afterA1.equals(" ") && afterA2.equals(" ")) && charList.get(i).equals("ะ")) {
                    charList.set(i, "ั");
                }

                if (isThaiConsonant(afterA1) && !isThaiConsonant(afterA2) && !isThaiVowel(afterA2) && !afterA2.equals("ฺ")) {
                    charList.set(i, "ั");
                }

            }
        }
        return convertListTostring(charList).trim();
    }

    public String convertThaiVowelPrefix(String thaiChar) {

        List<String> charList = charList(thaiChar);

        for (int i = 0; i < charList.size(); i++) {
            if (i > 0) {
                boolean check = charList.get(i).equals("เ") || charList.get(i).equals("โ") || charList.get(i).equals("ไ");
                if (check) {
                    String tmp = charList.get(i);
                    charList.set(i, charList.get(i - 1));
                    charList.set(i - 1, tmp);
                }
            }
        }

        return convertListTostring(charList).trim();
    }

    public String Mapper(Map<String, String> mapping, String romanize) {

        for (Map.Entry<String, String> entrySet : mapping.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            romanize = romanize.replaceAll(key, value);
        }
        return romanize;
    }

    public List<String> charList(String thaiChar) {
        List<String> charList = new ArrayList<>();
        char[] charArray = thaiChar.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charList.add(String.valueOf(charArray[i]));
        }
        return charList;
    }

    public static boolean isThaiVowel(String strChar) {
        Map<String, Boolean> mapping = MappingCharacter.mappingIsThaiVowel();
        return isCharacter(mapping, strChar);

    }

    public static boolean isThaiConsonant(String strChar) {
        Map<String, Boolean> mapping = MappingCharacter.mappingIsThaiConsonant();
        return isCharacter(mapping, strChar);
    }

    public static boolean isCharacter(Map<String, Boolean> mapping, String strChar) {

        Boolean returnVal = false;
        if (mapping.get(strChar) != null) {
            returnVal = mapping.get(strChar);
        }
        return returnVal;
    }

    public String convertListTostring(List<String> charList) {
        StringBuilder result = new StringBuilder("");
        for (String charList1 : charList) {
            result.append(charList1);
        }
        return result.toString();
    }

}
