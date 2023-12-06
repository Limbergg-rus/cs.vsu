package ru.vsu.cs.aslanovrenat.task10.Checker;

import ru.vsu.cs.aslanovrenat.task10.Checker.Checker;
import ru.vsu.cs.aslanovrenat.task10.DataBaseRealty;

public class Price implements Checker {
    int max;
    int min;
    public Price(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean check(DataBaseRealty d) {
        if (!((min == -1) && (max == -1))) {
            if (min == -1) {
                if ((d.price > max)) {
                    return false;
                }
            } else if(max == -1){
                if ((d.price < min)) {
                    return false;
                }
            } else{
                if ((d.price > max) || (d.price < min)) {
                    return false;
                }
            }
            return true;
        }
        return  true;

    }
}
