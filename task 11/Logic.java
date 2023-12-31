import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Logic {
    static void creatingaAllowCharacterSet(HashMap<Character, Integer> allowLetters) {
        String allowLetters123 = "abcdefghijklmnopqrstuvwxyz12@3456789-_.";
        char[] arr = allowLetters123.toCharArray();
        for (int i = 0; i < allowLetters123.length(); i++) {
            allowLetters.put(arr[i], 0);
        }
    }

    static void checkingCondition(String emailListInput, HashMap<Character, Integer> allowLetters, HashSet<String> newEmailList) {
        Logic.creatingaAllowCharacterSet(allowLetters);
        String[] emailList = emailListInput.split("(\\s|[,;])+");
        for (int i = 0; i < emailList.length; i++) {
                if (emailList[i].contains("@")) {
                    String beforeAtEmail = emailList[i].split("@")[0];
                    String afterAtEmail = emailList[i].split("@")[1];
                    if (extracted(allowLetters, beforeAtEmail) && extracted(allowLetters, afterAtEmail) &&
                            emailList[i].length() == beforeAtEmail.length() + afterAtEmail.length() + 1) {
                        newEmailList.add(emailList[i]);
                    }
                }
        }
    }

        private static boolean extracted (HashMap < Character, Integer > allowLetters, String checkHalf){
            int counter = 0;
            char[] inMomentEmail = checkHalf.toLowerCase().toCharArray();
            for (int k = 0; k < inMomentEmail.length; k++) {
                if ((k == 0 || k == inMomentEmail.length - 1) && inMomentEmail[k] == '.') {
                    break;
                }
                if (allowLetters.containsKey(inMomentEmail[k])) {
                    counter++;
                }
            }
            if (counter != 0 && counter == inMomentEmail.length) {
                return true;
            }
            return false;
        }
    }