package ru.vsu.cs.aslanovrenat.oldtasks.task3;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static final Line L1 = new Line(1, -4, 4);
    public static final HorizontalParabola P1 = new HorizontalParabola(0, 1, -1);
    public static final Line L2 = new Line(0, -2, -1);
    public static final Round R1 = new Round(0, -2, 25);
    public static final Rectangle Rc1 = new Rectangle(3, -5, 100000, -2);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);


/// Тесты
        System.out.printf("(10, 10) -> %s\n", getColor(10, 10));
        System.out.printf("(10, -3) -> %s\n", getColor(10, -3));
        System.out.printf("(10, -6) -> %s\n", getColor(10, -6));
        System.out.printf("(1, 500) -> %s\n", getColor(1, -500));
        System.out.printf("(4, 0) -> %s\n", getColor(4, 0));
        System.out.printf("(4, -3) -> %s\n", getColor(4, -3));
        System.out.printf("(3.5, 5.1) -> %s\n", getColor(3.5, -5.1));
        System.out.printf("(2, -5) -> %s\n", getColor(2, -5));
        System.out.printf("(1, 1 -> %s\n", getColor(1, 1));
        System.out.printf("(1, 50) -> %s\n", getColor(1, 50));
        System.out.printf("(-1, 1) -> %s\n", getColor(-1, 1));
        System.out.printf("(-4, 2.5) -> %s\n", getColor(-4, 2.5));
        System.out.printf("(-4, 0) -> %s\n", getColor(-4, 0));
        System.out.printf("(-3, -3) -> %s\n", getColor(-3, -3));
        System.out.printf("(-10, 5) -> %s\n", getColor(-10, 5));
        System.out.printf("(-10, 1) -> %s\n", getColor(-10, 1));
        System.out.printf("(3, -1) -> %s\n", getColor(3, -1));
        System.out.printf("(-10, -10) -> %s\n", getColor(-10, -10));
        System.out.print("Input X: ");
        double x = scanner.nextDouble();
        System.out.print("Input Y: ");
        double y = scanner.nextDouble();
        System.out.printf("(%.2f, %.2f) -> %s\n", x, y, getColor(x, y));
    }


    public static SimpleColor getColor(double x, double y) {
        if (P1.isPointRightOfParabola(x, y) && !L2.isPointAboveLine(x, y) && y > 3) {
            return SimpleColor.ORANGE;
        }
        if ((L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y) && R1.isPointInsideRound(x, y)
                && !P1.isPointRightOfParabola(x, y))) {
            return SimpleColor.ORANGE;
        }
        if ((L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y) && R1.isPointInsideRound(x, y)
                && !P1.isPointRightOfParabola(x, y))) {
            return SimpleColor.ORANGE;
        }
        if ((Rc1.isPointInsideRectangle(x, y) && !R1.isPointInsideRound(x, y))) {
            return SimpleColor.ORANGE;
        }
        if ((R1.isPointInsideRound(x, y) && x < 3 && y < -6 && L2.isPointAboveLine(x, y))) {
            return SimpleColor.ORANGE;
        }
        if ((!L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y) && R1.isPointInsideRound(x, y))) {
            return SimpleColor.GREEN;
        }
        if (L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y) && !R1.isPointInsideRound(x, y)
                && !P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.GREEN;
        }
        if (Rc1.isPointInsideRectangle(x, y) && R1.isPointInsideRound(x, y)) {
            return SimpleColor.GREEN;
        }
        if (!L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y) && !R1.isPointInsideRound(x, y)) {
            return SimpleColor.GRAY;
        }
        if (L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y) && R1.isPointInsideRound(x, y)
                && P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y) && R1.isPointInsideRound(x, y)
                && !P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y) && P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.BLUE;
        }
        if (!R1.isPointInsideRound(x, y) && y > -2 && L2.isPointAboveLine(x, y)) {
            return SimpleColor.BLUE;
        }
        if (R1.isPointInsideRound(x, y) && L2.isPointAboveLine(x, y) && !L1.isPointAboveLine(x, y) && y < -5) {
            return SimpleColor.BLUE;
        }
        return SimpleColor.WHITE;

    }
}
