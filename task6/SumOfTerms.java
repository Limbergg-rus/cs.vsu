package ru.vsu.cs.aslanovrenat.oldtasks.task6;

public class SumOfTerms {
    public double sumN;
    public double sumE;
    public double sumE10;

    public SumOfTerms(double sumN, double sumE, double sumE10) {
        this.sumN = sumN;
        this.sumE = sumE;
        this.sumE10 = sumE10;
    }

    public static SumOfTerms getDetails(int n, double e, double x) {
        // Инициализация переменных
        double sumN = x;
        double sumE = 0;
        double allsum = x;
        double sumE10 = 0;
        double term = x;
        double factorial = 1;
        double an = 1;
        int i = 1;
        if (Math.abs(sumN) > e) {
            sumE = sumN;
        }

        if (Math.abs(sumN) > e / 10) {
            sumE10 = sumN;
        }

        //Алгоритм подсчета
        while (i <= n || Math.abs(an) >= (e / 10)) {
            term *= (x * x);
            factorial *= (i * 2) * (i * 2 + 1);
            an = (term / factorial);
            if (i == n) {
                sumN = allsum;
            }
            if (Math.abs(an) > e) {
                sumE = allsum;
            }
            if (Math.abs(an) > (e / 10)) {
                sumE10 = allsum;
            }
            allsum += an;
            i++;
        }

        return new SumOfTerms(sumN, sumE, sumE10);
    }
}
