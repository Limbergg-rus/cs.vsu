package ru.vsu.cs.aslanovrenat.oldtasks.task7;

import java.util.*;

public class ArrayUtils {
    public static int[] readArrayFromConsole(String arrName) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                if (arrName == null || arrName.isEmpty()) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите массив%s:%n", arrName);
                String line = sc.nextLine();
                return inputArray(line);
            } catch (Exception e) {
                System.out.println("Вы ошиблись, попробуйте еще раз");
            }
        }
    }

    public static int[] inputArray(String str) {
        Scanner sc = new Scanner(str);
        sc.useLocale(Locale.ROOT);
        sc.useDelimiter("(\\s|[;,])+");
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        sc.close();
        Integer[] arr = list.toArray(new Integer[0]);
        return toPrimitive(arr);
    }

    private static int[] toPrimitive(Integer[] arr) {
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        /*
        if (arr == null) {
            return new int[0];
        }
        int[] result = new int[arr.length];
        Arrays.stream(arr).toArray();
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

         */

    }
}
