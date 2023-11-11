package ru.vsu.cs.aslanovrenat.task8;

import java.io.*;
import java.util.*;

public class InputAndOutput {
    // Считывание одномерного массива из файла
    public static int[] inputArray(String fileName) throws FileNotFoundException {
        List<Integer> line = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter("(\\s|[;,])+").useLocale(Locale.ROOT);
        while (sc.hasNextInt()) {
            line.add(sc.nextInt());
        }
        Integer[] arr = line.toArray(new Integer[0]);
        return toPrimitiveIntegerSingle(arr);
    }

    // Вывод двумерного массива в файл
    public static void outputArray(String fileName, int[][] array) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (int[] i : array) {
                writer.write(Arrays.toString(i) + ",\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Перевод в int[] одномерного массива
    private static int[] toPrimitiveIntegerSingle(Integer[] arr) {
        int rows = arr.length;
        int[] result = new int[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = arr[i];
        }
        if (result[0] < 1 || result[0] > 12 || result[1] < 0) {
            System.out.println("Введены некорректные данные");
            System.exit(0);
        }
        return result;
    }
}


// Перевод в int[][] двумерного массива
/* Считывание двумерного массива
    private static int[][] inputArray(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter("\n").useLocale(Locale.ROOT);
        List<List> totalList = new ArrayList<>();
        while (sc.hasNextLine()) {
            Scanner line = new Scanner(sc.nextLine());
            line.useDelimiter("(\\s|[;,])+").useLocale(Locale.ROOT);
            List<Integer> list = new ArrayList<>();
            while (line.hasNextInt()) {
                list.add(line.nextInt());
            }
            totalList.add(list);
            line.close();
        }
        sc.close();
        return listTo2DList(totalList);
    }

 */