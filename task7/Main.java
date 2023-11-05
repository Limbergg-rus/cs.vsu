package ru.vsu.cs.aslanovrenat.oldtasks.task7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название массива");
        String str = sc.nextLine();
        int[] arr = ArrayUtils.readArrayFromConsole(str);
        printAnswer(arr);
        printAnswer(ArrayUtils.inputArray("1 2 3 4 5 6"));
        printAnswer(ArrayUtils.inputArray("-1 2 -3 -4 7 56 53"));
        printAnswer(ArrayUtils.inputArray("6 10 15 8956 23 156 123 456"));
        printAnswer(ArrayUtils.inputArray("56 23  65 3 132 45 61 23 15 64 132"));
        printAnswer(ArrayUtils.inputArray("789456 13 21 654 12 156 413 2189 415"));
        printAnswer(ArrayUtils.inputArray("5 56 65 56 566  32"));
    }
    public static void printAnswer(int[] arr) {
        TheLongestSubstruction answerTheLongestSubstruction = TheLongestSubstruction.findingLongestSubstruction(arr);
        String answerSubstruction = Arrays.toString(answerTheLongestSubstruction.getAnsArray());
        System.out.printf("Последовательность: %s %n Самая длинная последовательность: %s%nДлина данной " +
                        "последовательности: %d%n",
                answerTheLongestSubstruction.getArray(), answerSubstruction, answerTheLongestSubstruction.getLength());
    }
}