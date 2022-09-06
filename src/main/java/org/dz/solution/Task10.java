package org.dz.solution;

import java.util.Random;

/*
Создайте массив из 11 случайных целых чисел из
отрезка [-1;1], выведите массив на экран в строку.
Определите какой элемент встречается в массиве
чаще всего и выведите об этом сообщение на экран.
Если два каких-то элемента встречаются одинаковое
количество раз, то не выводите ничего.
 */
public class Task10 {
    public void printResult() {
        int[] array = new int[11];

        fillArraysWithRandomNumbers(array);

        printArray(array);
        System.out.println();
        determineAndPrintAFrequentlyOccurringElementInAnArray(array);
    }

    private void fillArraysWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(3) - 1;
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private void determineAndPrintAFrequentlyOccurringElementInAnArray(final int[] array) {
        int minusOneQuantity = 0;
        int oneQuantity = 0;
        int zeroQuantity = 0;
        for (int j : array) {
            if (j == -1) {
                minusOneQuantity++;
            } else if (j == 1) {
                oneQuantity++;
            } else {
                zeroQuantity++;
            }
        }
        if (minusOneQuantity > oneQuantity && minusOneQuantity > zeroQuantity) {
            System.out.println("-1(" + minusOneQuantity + ") встречается чаще ");
        } else if (oneQuantity > minusOneQuantity && oneQuantity > zeroQuantity) {
            System.out.println("1(" + oneQuantity + ") встречается чаще ");
        } else if (zeroQuantity > minusOneQuantity && zeroQuantity > oneQuantity) {
            System.out.println("0(" + zeroQuantity + ") встречается чаще ");
        }
    }
}
