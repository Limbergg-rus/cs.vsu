package ru.vsu.cs.aslanovrenat.oldtasks.task2;
/*
Таск 22
В классе N мальчиков и M девочек. Необходимо разбить всех учеников на
команды так, чтобы в каждой команде было ровно по 3 человека (и мальчики и
девочки). Необходимо определить, какое максимальное кол-во команд, следуя

данным правилам, можно составить из учеников данного класса. (Очевидно, что
возможны ситуации, когда некоторые ученики не войдут ни в одну команду.)
1. Определить входные данные, выходные данные, их тип
2. Придумать интерфейс
3. Реализовать ввод данных
4. Решить задачу на листочке - получить формулы (пройтись по задачам и проговорить идеи)
5. Перенести формулу(ы) в код
6. Реализовать вывод результата
7. Вынести расчёт в функцию
8. Рефакторинг
 */

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static int calculateMaxTeams(int boys, int girls) {
        int maxTeams = 0;
        while (boys > 0 && girls > 0 && (boys + girls) > 2) {
            if (boys > girls) {
                boys -= 2;
                girls--;
            } else {
                girls -= 2;
                boys--;
            }
            maxTeams++;
        }
        return maxTeams;
    }

    public static boolean checkHuman(int boys, int girls) {
        return boys < 0 || girls < 0;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во юнош в классе: N = ");
        int boys = scanner.nextInt();
        System.out.print("Введите кол-во девушек в классе: M = ");
        int girls = scanner.nextInt();
        if (checkHuman(boys, girls)) {
            System.out.print("Кол-во учеников не может быть отрицательным");
            return;
        }
        System.out.printf("Максимальное кол-во групп равно %d", calculateMaxTeams(boys, girls));


    }

}