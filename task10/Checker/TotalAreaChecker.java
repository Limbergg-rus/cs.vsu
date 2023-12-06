package ru.vsu.cs.aslanovrenat.task10.Checker;

import ru.vsu.cs.aslanovrenat.task10.DataBaseRealty;

public class TotalAreaChecker implements Checker {
    int max;
    int min;

    public TotalAreaChecker(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean check(DataBaseRealty d) {
        if (!((min == -1) && (max == -1))) {
            if (min == -1) {
                if ((d.totalArea > max)) {
                    return false;
                }
            } else if (max == -1) {
                if ((d.totalArea < min)) {
                    return false;
                }
            } else {
                if ((d.totalArea > max) || (d.totalArea < min)) {
                    return false;
                }
            }
            return true;
        }
        return true;

    }
}
