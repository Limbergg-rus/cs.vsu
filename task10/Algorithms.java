package ru.vsu.cs.aslanovrenat.task10;

import ru.vsu.cs.aslanovrenat.task10.Checker.*;

import java.util.Scanner;

public class Algorithms {
    public static void process(String str, DataBaseRealty[] realty) {
        Scanner sc = new Scanner(str);
        String tag;
        int prMin = -1, prMax = -1, taMin = -1, taMax = -1, kaMin = -1, kaMax = -1, crMin = -1, crMax = -1;
        int value;
        sc.useDelimiter("(\\s|[,;])+");

        while (sc.hasNext()) {
            tag = sc.next();
            value = Integer.parseInt(sc.next());
            switch (tag) {
                case ("-mxpr"):
                    prMax = value;
                    break;
                case ("-mnpr"):
                    prMin = value;
                    break;
                case ("-mxta"):
                    taMax = value;
                    break;
                case ("-mnta"):
                    taMin = value;
                    break;
                case ("-mxka"):
                    kaMax = value;
                    break;
                case ("-mnka"):
                    kaMin = value;
                    break;
                case ("-mxcr"):
                    crMax = value;
                    break;
                case ("-mncr"):
                    crMin = value;
                    break;
            }
        }
        sortingByParams(realty, prMin, prMax, taMin, taMax, kaMin, kaMax, crMin, crMax);
    }

    public static void sortingByParams(DataBaseRealty[] realty, int prMin, int prMax, int taMin, int taMax, int kaMin, int kaMax, int crMin, int crMax) {
        Checker[] checkers = new Checker[]{
                new Price(prMax, prMin), new KitchenAreaChecker(kaMax, kaMin),
                new TotalAreaChecker(taMax, taMin), new CountRooms(crMax, crMin),
        };
        for (Checker checker : checkers) {
            for (int i = 0; i < realty.length; i++) {
                if ((realty[i] != null) && !checker.check(realty[i])) {
                    realty[i] = null;
                }
            }
        }
    }
}
