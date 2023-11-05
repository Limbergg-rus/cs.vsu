package ru.vsu.cs.aslanovrenat.oldtasks.task3;

public class Rectangle {
    public double x0;
    public double x1;
    public double y0;
    public double y1;

    public Rectangle(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public boolean isPointInsideRectangle(double x, double y) {
        return y0 <= y && y <= y1 && x0 <= x && x <= x1;
    }
}