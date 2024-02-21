import util.SwingUtils;

import java.awt.*;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedListNew arr = new LinkedListNew();
//        arr.addFirst(2);
//        arr.addFirst(3);
//        arr.addFirst(5);
//        arr.addLast(568653);
//        arr.addFirst(7);
//        arr.addFirst(2);
//        arr.add(6,458976984);
//        LinkedListNew.print(arr);
//        arr.get(5);
        winMain();
    }
    private static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }



    public static LinkedList randomInt() {
        LinkedList<Integer> arr = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr.add(random.nextInt(100) + 1);
        }
        return arr;
    }

    public static LinkedList fillIntArr() {
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i + 1);
        }
        return arr;
    }
}




/*
Для двухсвязного списка, для которого хранятся ссылки на первый и последний элемент
и кол-во элементов, реализовать оптимальный метод поиска k-го по счету (начиная с
начала списка) элемента. Надо проверить, k-ый элемент ближе к началу или к концу
списка, и «добираться» до данного элемента, начиная или с начала или с конца.

Ввод
k-ый по счету элемент
первый элемент
последний эелемент
Вывод
оптимальный вывод k-ый элемент
 */