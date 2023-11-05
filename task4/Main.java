package ru.vsu.cs.aslanovrenat.oldtasks.task4;

import java.util.Locale;
import java.util.Scanner;

/*
22. Найти N-ое по счету положительное 3-хзначное число, такое, что 2 цифры числа одинаковые (3-я
цифра другая). Если такого числа найти нельзя (n слишком большое, вернуть 0). Для
определения, подходит ли число под требования задачи, реализовать функцию. Также
реализовать функцию для нахождения N-ого по счету числа.
 */
public class Main {
    public static boolean conditionMet(int number) {
        int numberHundreds = number / 100; // цифра сотен
        int numberDozens = number / 10 % 10; // цифра десятков
        int numberUnits = number % 10; // цифра единиц
        return ((numberHundreds == numberDozens && numberHundreds != numberUnits) ||
                (numberHundreds != numberDozens && numberDozens == numberUnits) ||
                (numberHundreds != numberDozens && numberHundreds == numberUnits)) &&
                number >= 100 && number <= 999;
    }

    public static int calculating(int n) {
        int number = 99;
        int k = 0;
        while (n != k) {
            number++;
            if (conditionMet(number)) {
                k++;
            }
            if (number > 999) {
                return 0;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение N: ");
        int n = scanner.nextInt();
        System.out.printf("%d-ое трехзначное число соответствующее условию равно: %d", n, calculating(n));
    }
}
