package org.dz.solution;

import java.util.Random;

/*
Дан одномерный массив символов.
Преобразовать его в одномерный массив чисел,
где число - это код символа (любой символ - это число в памяти компьютера).
Например: ['a','6','c','P','T','q','9','+'] -> [97, 54, 99, 80, 84, 113, 57, 43]

Далее определить среднее арифметическое всех элементов
целочисленного массива и вывести на консоль только те элементы,
которые больше этого среднего арифметического.
 */
public class Task19 {
    public void printResult() {
        int[] array = new int[10];
        fillArraysWithRandomNumbers(array);

        printArray(array);

        System.out.println();

        double averageValue = getAverage(array);
        System.out.println(averageValue);

        printElementsGreaterThanTheArithmeticMean(array, averageValue);
    }

    private void fillArraysWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) generator.nextInt(128);
        }
    }


    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    private double getAverage(final int[] array) {
        double result = 0;
        for (int number : array) {
            result += number;
        }
        return result / array.length;
    }

    private void printElementsGreaterThanTheArithmeticMean(final int[] array, final double averageValue) {
        for (int j : array) {
            if (j > averageValue) {
                System.out.print((char) j + " ");
            }
        }
    }
}
