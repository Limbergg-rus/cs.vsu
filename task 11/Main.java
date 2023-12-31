import Utils.SwingUtils;

import java.io.FileNotFoundException;
import java.util.*;

import static Utils.ArrayUtils.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        winMain();
    }

    private static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}


//    String[][] emailListInput = readStringFile("input.txt");
//        HashMap<Character, Integer> allowLetters = new HashMap<>();
//        HashSet<String> newEmailList = new HashSet<>();
//
//        Logic.creatingaAllowCharacterSet(allowLetters);
//        Logic.checkingCondition(emailListInput, allowLetters, newEmailList);
//        writeStringArrayToFile("output.txt",hashSetToString(newEmailList));


//        Ебаный в рот столько убил времени чтобы нельзя было использовать....(((
//        Pattern pattern = Pattern.compile("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$");
//        Matcher matc
////
//        System.out.println(Pattern.matches(String.valueOf(pattern), "sd..f.s.d.f@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", ".sdfsdf@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", "&sdfsdf@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", "$sdfsdf@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", "%sdfsdf@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", ".sdfsdf@adsf.sdf"));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", "sdfsdf_-___--@adsf.sdf."));
//        System.out.println(Pattern.matches("^((?!\\.)[\\w-_.]*[^.])(@[\\w-_.]*[^.])$", "sd fsdf@adsf.sdf"));
////        System.out.println(Pattern.matches("((?!\\.)[\\w+-.]*[^.])(@([\\w+-.]*[^.]))(?!\\s)$", "sd fsdf@adsf.sdf"));
////        System.out.println(Pattern.matches("^((?!\\.)[\\w+-.]*[^.])(@([\\w+-.]*[^.]))(?!.)", "sd fsdf@adsf.sdf"));


//        String str = "abcdefghijklmnopqrstuvwxyz123456789-_";
//        String str1 = "dsfsdf@sdfsdf";
//        Scanner sc = new Scanner(str);
//        sc.useDelimiter("");
//        for (int i = 0; i < 32; i++){
//            System.out.print((char) (i + 97));
//(*) Из текста выбрать (в виде списка) без повторений все email-адреса. За email-адрес
//        будет принимать любой фрагмент вида X@X, где X – любая последовательность букв
//        английского алфавита, цифр, а также символов точка, '-' и '_' (естественно, первым и
//        последним символом не может быть точка). При желании можно более полно проверять
//        email-адрес согласно RFC 5322. При реализации регулярные выражения не использовать
//        (как и для всех остальных задач, но для этой задачи стоит напомнить об этом еще раз
//        отдельно).
