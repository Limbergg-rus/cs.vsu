package ru.vsu.cs.aslanovrenat.task10.Checker;

import ru.vsu.cs.aslanovrenat.task10.DataBaseRealty;

public class KitchenAreaChecker implements Checker {

    int max;
    int min;
    public KitchenAreaChecker(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean check(DataBaseRealty d) {
        if (!((min == -1) && (max == -1))) {
            if (min == -1) {
                if ((d.kitchenArea > max)) {
                    return false;
                }
            } else if(max == -1){
                if ((d.kitchenArea < min)) {
                    return false;
                }
            } else{
                if ((d.kitchenArea > max) || (d.kitchenArea < min)) {
                    return false;
                }
            }
            return true;
        }
        return  true;

    }
}
