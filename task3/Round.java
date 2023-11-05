package ru.vsu.cs.aslanovrenat.oldtasks.task3;

public class Round {
    public double x0;
    public double y0;
    public double a;

    public Round(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInsideRound(double x, double y) {
        return Math.pow(y - y0, 2) + Math.pow(x - x0, 2) <= a;
    }
}