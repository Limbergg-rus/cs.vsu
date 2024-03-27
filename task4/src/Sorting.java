import java.util.HashSet;

public class Sorting {
    public static String[] combSorting(String[] startArray) {
        HashSet<Character> vowels = vowelsHashSet();
        int gap = startArray.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.25);
            int i = 0;
            swapped = false;
            while (gap + i < startArray.length) {
                int a = getCountVowels(startArray[i], vowels);
                int b = getCountVowels(startArray[gap + i], vowels);
                if (a < b || (a == b && startArray[i].length() < startArray[i + gap].length())) {
                    String t = startArray[i];
                    startArray[i] = startArray[gap + i];
                    startArray[gap + i] = t;
                    swapped = true;
                }
                i++;
            }
        }
        return startArray;
    }

    private static HashSet<Character> vowelsHashSet() {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        return vowels;
    }

    public static int getCountVowels(String str, HashSet<Character> vowels) {
        int i = 0;
        for (var letter : str.toCharArray()) {
            i += vowels.contains(letter) ? 1 : 0;
        }
        return i;
    }
}
