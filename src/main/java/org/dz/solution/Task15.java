package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

/*
Создать двумерный массив из 5 строк по 8 столбцов в
каждой из случайных целых чисел из отрезка [-99;99].
Вывести массив на экран. После на отдельной строке
вывести на экран значение максимального элемента этого
массива (его индекс не имеет значения).
 */
public class Task15 {
    private final ArrayHelper helper = new ArrayHelper();

    public void printResult() {
        int[][] array = new int[5][8];

        fillArraysWithRandomNumbers(array);

        printArray(array);

        System.out.println();
        System.out.println("Значение максимального элемента массива = " + getMaxElementOfTheArray(array));
    }

    private void fillArraysWithRandomNumbers(final int[][] array) {
        for (int[] ints : array) {
            helper.fillArrayWithRandomNumbers(ints, generator -> generator.nextInt(199) - 99);
        }
    }

    private void printArray(final int[][] array) {
        for (int[] ints : array) {
            helper.printArray(ints);
            System.out.println();
        }
    }

    private int getMaxElementOfTheArray(final int[][] array) {
        int max = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }
}
