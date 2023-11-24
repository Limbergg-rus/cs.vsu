package ru.vsu.cs.aslanovrenat.oldtasks.task10;

import java.util.Scanner;

public class Algorithms {
    public static void priceCondition(int mxpr, int mnpr, DataBaseRealty[] db) {
        for (int i = 0; i < db.length; i++) {
            if (db[i] != null) {
                if (mxpr == -1) {
                    if (!(db[i].price > mnpr)) {
                        db[i] = null;
                    }

                } else {
                    if (!(db[i].price < mxpr)) {
                        db[i] = null;
                    }
                }
            }
        }
    }

    public static void countRoomCondition(int mxpr, int mnpr, DataBaseRealty[] db) {
        for (int i = 0; i < db.length; i++) {
            if (db[i] != null) {
                if ((mnpr == -1)) {
                    if (!(db[i].countRooms < mxpr)) {
                        db[i] = null;
                    }
                } else {
                    if (!(db[i].countRooms > mnpr)) {
                        db[i] = null;
                    }
                }
            }
        }
    }

    public static void kitchenAreaCondition(int mxpr, int mnpr, DataBaseRealty[] db) {
        for (int i = 0; i < db.length; i++) {
            if (db[i] != null) {
                if (mnpr == -1) {
                    if (!(db[i].kitchenArea < mxpr)) {
                        db[i] = null;
                    }
                } else {
                    if (!(db[i].kitchenArea > mnpr)) {
                        db[i] = null;
                    }
                }
            }
        }
    }

    public static void totalAreaCondition(int mxpr, int mnpr, DataBaseRealty[] db) {
        for (int i = 0; i < db.length; i++) {
            if (db[i] != null) {
                if (mnpr == -1) {
                    if (!(db[i].totalArea < mxpr)) {
                        db[i] = null;
                    }
                } else {
                    if (!(db[i].totalArea > mnpr)) {
                        db[i] = null;
                    }
                }
            }
        }
    }

    public static void process(String str, DataBaseRealty[] realty) {
        Scanner sc = new Scanner(str);
        String tag;
        String value;
        sc.useDelimiter("(\\s|[,;])+");
        while (sc.hasNext()) {
            tag = sc.next();
            value = sc.next();
            if (tag.equals("-mxpr")) {
                priceCondition(Integer.parseInt(value), -1, realty);
            }
            if (tag.equals("-mnpr")) {
                priceCondition(-1, Integer.parseInt(value), realty);
            }
            if (tag.equals("-mxta")) {
                totalAreaCondition(Integer.parseInt(value), -1, realty);
            }
            if (tag.equals("-mnta")) {
                totalAreaCondition(-1, Integer.parseInt(value), realty);
            }
            if (tag.equals("-mxka")) {
                kitchenAreaCondition(Integer.parseInt(value), -1, realty);
            }
            if (tag.equals("-mnka")) {
                kitchenAreaCondition(-1, Integer.parseInt(value), realty);
            }
            if (tag.equals("-mxcr")) {
                countRoomCondition(Integer.parseInt(value), -1, realty);
            }
            if (tag.equals("-mncr")) {
                countRoomCondition(-1, Integer.parseInt(value), realty);
            }
        }
    }
}
