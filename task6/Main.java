package ru.vsu.cs.aslanovrenat.oldtasks.task6;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите любое значение x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();
        System.out.print("Введите значение e: ");
        double e = scanner.nextDouble();
        SumOfTerms summa = SumOfTerms.getDetails(n, e, x);
        System.out.printf("Сумма %d слагаемых равна: %f ", n, summa.sumN);
        System.out.printf("%nCумма тех слагаемых, которые по абсолютной величине больше e: %f", summa.sumE);
        System.out.printf("%nCумма тех слагаемых, которые по абсолютной величине больше e/10: %f", summa.sumE10);
        System.out.printf("%nЗначение функции с помощью метода Math.sinh(%.2f): %f", x, Math.sinh(x));
    }
}
