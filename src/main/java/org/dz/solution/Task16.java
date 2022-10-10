package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

import java.util.Random;

/*
Создать двумерный массив из 7 строк по 4 столбца в
каждой из случайных целых чисел из отрезка [-5;5].
Вывести массив на экран. Определить и вывести на экран
индекс строки с наибольшим по модулю произведением элементов.
Если таких строк несколько, то вывести индекс первой встретившейся из них.
 */
public class Task16 {
    public void printResult() {
        int[][] sourceMatrix = new int[7][4];
        int[] multiplicationNumbersInLineArray = new int[sourceMatrix.length];

        fillMatrixWithRandomNumbers(sourceMatrix);
        printMatrix(sourceMatrix);

        System.out.println();

        calculateMultiplications(multiplicationNumbersInLineArray, sourceMatrix);
        ArrayHelper helper = new ArrayHelper();
        helper.printArray(multiplicationNumbersInLineArray);

        System.out.println();

        convertToPositiveArray(multiplicationNumbersInLineArray);

        printMaxIndexAndMaxResult(multiplicationNumbersInLineArray);
    }

    private void fillMatrixWithRandomNumbers(int[][] sourceMatrix) {
        Random generator = new Random();
        for (int i = 0; i < sourceMatrix.length; i++) {
            for (int j = 0; j < sourceMatrix[i].length; j++) {
                sourceMatrix[i][j] = generator.nextInt(11) - 5;
            }
        }
    }

    private void printMatrix(int[][] sourceMatrix) {
        for (int[] matrix : sourceMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private void calculateMultiplications(int[] multiplicationNumbersInLineArray, int[][] sourceMatrix) {
        for (int i = 0; i < sourceMatrix.length; i++) {
            for (int j = 0; j < sourceMatrix[i].length; j++) {
                if (j == 0) {
                    multiplicationNumbersInLineArray[i] = sourceMatrix[i][j];
                } else {
                    multiplicationNumbersInLineArray[i] = multiplicationNumbersInLineArray[i] * sourceMatrix[i][j];
                }
            }
        }
    }

    private void convertToPositiveArray(int[] multiplicationNumbersInLineArray) {
        for (int i = 0; i < multiplicationNumbersInLineArray.length; i++) {
            multiplicationNumbersInLineArray[i] = Math.abs(multiplicationNumbersInLineArray[i]);
        }
    }

    private void printMaxIndexAndMaxResult(int[] multiplicationNumbersInLineArray) {
        int max = 0, index = 0;
        for (int i = 0; i < multiplicationNumbersInLineArray.length; i++) {
            if (multiplicationNumbersInLineArray[i] > max) {
                max = multiplicationNumbersInLineArray[i];
                index = i;
            }
        }
        System.out.println("Индекс строки с наибольшим по модулю произведением элементов " + index);
        System.out.println("произведением элементов " + max);
    }
}