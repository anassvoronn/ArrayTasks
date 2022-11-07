package org.dz.solution;

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
        // Найти количество > 0
        // Найти количество < 0
        // Найти количество = 0
        // > 0 записать в массив
        // < 0 записать в массив
        // = 0 записать в массив
        // собрать матрицу
        int[] array1 = new int[getNumberOfNegativeNumbers(array)];
        int[] array2 = new int[getNumberOfPositiveNumbers(array)];
        int[] array3 = new int[getNumberOfZeros(array)];
        System.out.println(getMatrix(array1, array2, array3));
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

    private int[] getPositiveNumbersArray(final int[] array) {
        int counter = getNumberOfPositiveNumbers(array);
        return new int[counter];
    }

    private int[] getNegativeNumbersArray(final int[] array) {
        int counter = getNumberOfNegativeNumbers(array);
        return new int[counter];
    }

    private int[] getZerosNumbersArray(final int[] array) {
        int counter = getNumberOfZeros(array);
        return new int[counter];
    }

    private int[][] getMatrix(final int[] array1, final int[] array2, final int[] array3) {
        int[] negativeNumbersArray = getNegativeNumbersArray(array1);
        int[] positiveNumbersArray = getPositiveNumbersArray(array2);
        int[] zerosNumbersArray = getZerosNumbersArray(array3);
        return new int[][]{negativeNumbersArray, positiveNumbersArray, zerosNumbersArray};
    }
}
