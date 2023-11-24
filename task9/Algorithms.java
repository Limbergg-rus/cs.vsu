package ru.vsu.cs.aslanovrenat.oldtasks.task9;

import ru.vsu.cs.aslanovrenat.oldtasks.task9.Utils.JTableUtils;

import javax.swing.*;
import java.util.List;

public class Algorithms {
    public static void jTableProcess(JTable tableOutput, JTable tableInput) throws JTableUtils.JTableUtilsException {
        List<Integer> list = InputAndOutput.integerToList(JTableUtils.readArrayFromJTable(tableInput,
                Integer.class, Integer::parseInt, false, 0));
        process(list);
        Integer[] arr = list.toArray(new Integer[0]);
        JTableUtils.writeArrayToJTable(tableOutput, arr);
    }

    public static void process(List<Integer> list) {
        int temp;
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                temp = list.get(i);
                for (int j = 0; j < i - k; j++) {
                    list.set(i - j, list.get(i - j - 1));
                }
                list.set(k, temp);
                k++;
            }
        }
    }
}
