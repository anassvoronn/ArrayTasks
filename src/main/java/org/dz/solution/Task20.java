package org.dz.solution;

import java.util.Random;
import java.util.function.Predicate;

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

        int numberOfNegativeNumbers = getNumberOf(array, number -> number < 0);
        int numberOfPositiveNumbers = getNumberOf(array, number -> number > 0);
        int numberOfZeros = getNumberOf(array, number -> number == 0);

        int[] array1 = new int[numberOfNegativeNumbers];
        int[] array2 = new int[numberOfPositiveNumbers];
        int[] array3 = new int[numberOfZeros];

        fillArrayWith(array, array2, number -> number > 0);
        System.out.println("Массив с положительными числами:");
        printArray(array2);

        System.out.println();

        fillArrayWith(array, array1, number -> number < 0);
        System.out.println("Массив с отрицательными числами:");
        printArray(array1);

        System.out.println();

        fillArrayWith(array, array3, number -> number == 0);
        System.out.println("Массив с нулями:");
        printArray(array3);

        System.out.println();
        System.out.println();

        int[][] matrix = {array1, array2, array3};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
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

    private int getNumberOf(final int[] array, Predicate<Integer> predicate) {
        int counter = 0;
        for (int j : array) {
            if (predicate.test(j)) {
                counter++;
            }
        }
        return counter;
    }

    private void fillArrayWith(final int[] array, final int[] result, Predicate<Integer> predicate) {
        int counter = 0;
        for (int j : array) {
            if (predicate.test(j)) {
                result[counter] = j;
                counter++;
            }
        }
    }
}
