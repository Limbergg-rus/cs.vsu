package ru.vsu.cs.aslanovrenat.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class InputAndOutput {

    public static void outputDataBaseArray(DataBaseRealty[] db, String fileName) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (DataBaseRealty i : db) {
                if (i != null) {
                    writer.write(i.name + ", " + i.countRooms + ", " + i.totalArea + ", " + i.kitchenArea + ", " + i.price + "\n");
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static DataBaseRealty inputDataBase(DataBaseRealty db, String line) throws FileNotFoundException {
        Scanner sc = new Scanner(line);
        String str;
        String name = sc.next();
        sc.useDelimiter("(\\s|[,;])+");

        while (sc.hasNext()) {
            str = sc.next();
            if (str.matches("[-+]?\\d+")) {
                db = new DataBaseRealty(name.replace(",", ""), Integer.parseInt(str), sc.nextInt(), sc.nextInt(), sc.nextInt());
            } else {
                name = name + " " + str;
            }
        }
        sc.close();
        return db;
    }

    public static String[] inputList(String[] db, String line) throws FileNotFoundException {
        Scanner sc = new Scanner(line);
        String str;
        String name = sc.next();
        sc.useDelimiter("(\\s|[,;])+");

        while (sc.hasNext()) {
            str = sc.next();
            name = name.replace(",", "");
            if (str.matches("[-+]?\\d+")) {
                db[0] = (name);
                db[1] = (str);
                db[2] = (sc.next());
                db[3] = (sc.next());
                db[4] = (sc.next());
            } else {
                name = name + " " + str;
            }
        }
        sc.close();
        return db;
    }

    public static String[][] inputListArray(String[][] db, String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        for (int i = 0; i < db.length; i++) {
            String str = sc.nextLine();
            db[i] = inputList(db[(i)], str);
        }
        sc.close();
        return db;

    }

    public static void inputDataBaseArray(DataBaseRealty[] db, String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        for (int i = 0; i < db.length; i++) {
            String str = sc.nextLine();
            db[i] = inputDataBase(db[i], str);
        }
        sc.close();
    }

    public static DataBaseRealty[] stringToDataBase(String[][] arr) {
        DataBaseRealty[] realty = new DataBaseRealty[arr.length];
        for (int i = 0; i < arr.length; i++) {
            realty[i] = new DataBaseRealty(arr[i][0], Integer.parseInt(arr[i][1]), Integer.parseInt(arr[i][2]), Integer.parseInt(arr[i][3]), Integer.parseInt(arr[i][4]));
//            realty[i].name = arr[i][0];
//            realty[i].countRooms = Integer.parseInt(arr[i][1]);
//            realty[i].totalArea = Integer.parseInt(arr[i][2]);
//            realty[i].kitchenArea = Integer.parseInt(arr[i][3]);
//            realty[i].price = Integer.parseInt(arr[i][4]);
        }
        return realty;
    }

    public static String[][] dataBaseToString(DataBaseRealty[] realty) {
        String[][] arr = new String[realty.length][5];
        int k = 0;
        for (int i = 0; i < realty.length; i++) {
            if (realty[i] != null) {
                arr[k][0] = realty[i].name.replace(',', ' ');
                arr[k][1] = String.format("%d", realty[i].countRooms);
                arr[k][2] = String.format("%d", realty[i].totalArea);
                arr[k][3] = String.format("%d", realty[i].kitchenArea);
                arr[k][4] = String.format("%d", realty[i].price);
                k++;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }


    public static int countLines(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        int k = 0;
        while (true) {
            if (sc.hasNextLine()) {
                sc.nextLine();
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
