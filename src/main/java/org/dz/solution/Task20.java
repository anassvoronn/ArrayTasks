package org.dz.solution;

import java.util.Arrays;
import java.util.Random;

/*
Дан одномерный массив целых чисел.
Написать функцию, которая принимает
этот массив и разбивает на 3 других:
с только отрицательными числами, только
положительными и только нули. Если для
какого-то из массивов не будет значений,
то должен быть создан пустой массив.
Возвращает функция эти три массива в виде одного двумерного.
Пример:
                            [-4, -18]
[-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
                            [1, 9, 3]
 */
public class Task20 {
    public void printResult() {
        int[] array = new int[20];
        fillArraysWithRandomNumbers(array);
        printArray(array);

        System.out.println();

        int numberOfNegativeNumbers = getNumberOfNegativeNumbers(array);
        int numberOfPositiveNumbers = getNumberOfPositiveNumbers(array);
        int numberOfZeros = getNumberOfZeros(array);

        int[] array1 = new int[numberOfNegativeNumbers];
        int[] array2 = new int[numberOfPositiveNumbers];
        int[] array3 = new int[numberOfZeros];

        fillArrayWithPositiveNumbers(array, array2);
        printArray(array2);

        System.out.println();

        fillArrayWithNegativeNumbers(array, array1);
        printArray(array1);

        System.out.println();

        fillArrayWithZeros(array, array3);
        printArray(array3);

        System.out.println();

        int[][] matrix = new int[][]{array1, array2, array3};
        System.out.println(Arrays.deepToString(matrix));
    }

    private void fillArraysWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(7) - 3;
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private int getNumberOfNegativeNumbers(final int[] array) {
        int counter = 0;
        for (int j : array) {
            if (j < 0) {
                counter++;
            }
        }
        return counter;
    }

    private int getNumberOfPositiveNumbers(final int[] array) {
        int counter = 0;
        for (int j : array) {
            if (j > 0) {
                counter++;
            }
        }
        return counter;
    }

    private int getNumberOfZeros(final int[] array) {
        int counter = 0;
        for (int j : array) {
            if (j == 0) {
                counter++;
            }
        }
        return counter;
    }

    private void fillArrayWithPositiveNumbers(final int[] array, final int[] result) {
        int counter = 0;
        for (int j : array) {
            if (j > 0) {
                result[counter] = j;
                counter++;
            }
        }
    }

    private void fillArrayWithNegativeNumbers(final int[] array, final int[] result) {
        int counter = 0;
        for (int j : array) {
            if (j < 0) {
                result[counter] = j;
                counter++;
            }
        }
    }

    private void fillArrayWithZeros(final int[] array, final int[] result) {
        int counter = 0;
        for (int j : array) {
            if (j == 0) {
                result[counter] = j;
                counter++;
            }
        }
    }
}
