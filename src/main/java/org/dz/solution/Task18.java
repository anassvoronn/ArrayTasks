package org.dz.solution;

import java.util.Random;

/*
Дан одномерный массив целых чисел.
Написать функцию, удаляющую из него все
отрицательные элементы (удалить - значит
создать новый массив с только положительными
элементами).После удаления - умножить каждый
элемент массива на его длину.
Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class Task18 {
    public void printResult() {
        int[] array1 = new int[10];
        populateArrayWithRandomNumbers(array1);
        printArray(array1);

        System.out.println();

        int numberOfNonNegativeNumbers = getNumberOfNonNegativeNumbers(array1);
        System.out.println(numberOfNonNegativeNumbers);

        int[] array2 = new int[numberOfNonNegativeNumbers];
        fillNonNegativeNumbersTo2Array(array1, array2);
        printArray(array2);

        System.out.println();

        multiplyEachElementOf2ArrayByItsLength(array2);
        printArray(array2);
    }

    private void populateArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(31) - 15;
        }
    }

    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    private int getNumberOfNonNegativeNumbers(final int[] array) {
        int numberOfNonNegativeNumbers = 0;
        for (int j : array) {
            if (j >= 0) {
                numberOfNonNegativeNumbers++;
            }
        }
        return numberOfNonNegativeNumbers;
    }

    private void fillNonNegativeNumbersTo2Array(final int[] array1, final int[] array2) {
        int nonNegativeNumberIndex = 0;
        for (int number : array1) {
            if (number >= 0) {
                array2[nonNegativeNumberIndex] = number;
                nonNegativeNumberIndex++;
            }
        }
    }

    private void multiplyEachElementOf2ArrayByItsLength(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array.length;
        }
    }
}

