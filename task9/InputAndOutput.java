package ru.vsu.cs.aslanovrenat.oldtasks.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputAndOutput {
    // Считывание Листа из файла
    public static List<Integer> inputListArray(String fileName) throws FileNotFoundException {
        List<Integer> line = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter("(\\s|[;,])+").useLocale(Locale.ROOT);
        while (sc.hasNextInt()) {
            line.add(sc.nextInt());
        }
        return line;
    }

    // Вывод Листа в файл
    public static void outputListArray(String fileName, List<Integer> array) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(array + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Вывод Intger -> List
    public static List<Integer> integerToList(Integer[] arr) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
        }
        return array;
    }
}
