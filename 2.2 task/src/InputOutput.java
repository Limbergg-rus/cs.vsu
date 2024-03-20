import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputOutput {

    // Заполнение стека


    static String[] parrseString(String s) {
        Scanner sc = new Scanner(s);
        List<String> arr = new ArrayList<>();
        Locale.setDefault(Locale.ROOT);
        sc.useDelimiter("(\\s|[,;])+");
        while (sc.hasNext()) {
            arr.add(sc.next());
        }
        return toPrimitive(arr);
    }

    public static String[] toPrimitive(List<String> arr) {
        String[] newArr = new String[arr.size()];
        int i = 0;
        for (var item : arr) {
            newArr[i] = item;
            i++;
        }
        return newArr;
    }
}
