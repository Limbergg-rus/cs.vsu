package ru.vsu.cs.aslanovrenat.oldtasks.task8;

import java.util.ArrayList;
import java.util.List;

public class Algoritmes {
    // Основная функция для вывода Календаря
    public static int[][] calendarPrinter(int[] date) {
        List<List> array = new ArrayList<>(); // Общий лист
        List<Integer> line = new ArrayList<>(); // Лист для каждой строки
        prevDays(line, date);
        endMainDays(array, line, date);
        return listTo2DList(array);
    }

    // Первеод двумерного Листа в двумерный массив
    private static int[][] listTo2DList(List<List> totalList) {
        Integer[][] arr = new Integer[totalList.size()][1];
        int k = 0;
        for (List i : totalList) {
            arr[k] = (Integer[]) i.toArray(new Integer[0]);
            k++;
        }
        return toPrimitiveIntegerDouble(arr);
    }

    //Перевод Двумерного листа в двумерную коллекцию целочисленных чисел
    private static int[][] toPrimitiveIntegerDouble(Integer[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                result[i][k] = arr[i][k];
            }
        }
        return result;
    }

    // вывод дней до первого дня основного месяца
    private static List<Integer> prevDays(List<Integer> line, int[] date) {
        int prevDays = dayCounter(new int[]{date[0] - 1, date[1]});
        int i = zeroBag(startPoint(date));
        for (int k = 1; k < i; k++) {
            line.add(prevDays - i + k + 1);
        }
        return line;
    }

    //Вывод дней основного месяца и еще дней до конца недели
    private static List<List> endMainDays(List<List> array, List<Integer> line, int[] date) {
        int days = dayCounter(date);
        int j = line.size() + 1;
        int i = 1;
        int totalCapacity = startPoint(date) - 1 + days;
        int endDays = zeroBag(totalCapacity % 7);
        int sumOfDays = 7 - endDays + totalCapacity;
        while (j <= sumOfDays) {
            if (i > days) {
                line.add(i - days);
            } else {
                line.add(i);
            }
            if (j % 7 == 0) {
                array.add(line);
                line = new ArrayList<>();
            }
            i++;
            j++;
        }
        return array;
    }

    // Определние кол-ва дней в одном месяце
    private static int dayCounter(int[] arr) {
        int days = 0;
        int year = arr[1];
        days = switch (arr[0]) {
            case 2 -> leapYear(year);
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> days;
        };
        return days;
    }

    // Высчитывание количества дней в феврале
    private static int leapYear(int year) {
        if (year % 4 == 0) {
            return 29;
        }
        return 28;
    }

    // Определение первого дня недели
    private static int startPoint(int[] data) {
        int month = data[0];
        int year = data[1];
        if (month < 3) {
            --year;
            month += 10;
        } else
            month -= 2;
        return ((1 + 31 * month / 12 + year + year / 4 - year / 100 + year / 400) % 7);
    }

    //Не баг а фича при делниее на 7
    private static int zeroBag(int i) {
        if (i == 0) {
            i = 7;
        }
        return i;
    }
}
