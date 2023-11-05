package ru.vsu.cs.aslanovrenat.oldtasks.task7;

import java.util.Arrays;

public class TheLongestSubstruction {
    private int[] array;
    private int length;
    private String firstArray;

    private TheLongestSubstruction(int[] array, String firstArray, int length) {
        this.array = array;
        this.firstArray = firstArray;
        this.length = length;
    }

    public String getArray() {
        return this.firstArray;
    }

    public int[] getAnsArray() {
        return this.array;
    }

    public int getLength() {
        return this.length;
    }

    public static TheLongestSubstruction findingLongestSubstruction(int[] arr) {
        int k = 1;
        int maxK = 0;
        int firstIMax = 0;
        int firstI = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] + arr[i + 1]) % 2 == 1) {
                k++;
                if (k >= maxK) {
                    maxK = k;
                    firstIMax = firstI;
                }
            } else {
                k = 1;
                firstI = i + 1;
            }

        }
        return creatingNewArray(firstIMax, maxK, arr);
    }

    private static TheLongestSubstruction creatingNewArray(int firstIMax, int maxK, int[] arr) {
        int[] ansArray = new int[maxK];
        System.arraycopy(arr, firstIMax, ansArray, 0, maxK);
        return new TheLongestSubstruction(ansArray, Arrays.toString(arr), maxK);
    }
}
