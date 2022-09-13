package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

import java.util.Random;

/*
Создать двумерный массив из 8 строк по 5 столбцов
в каждой из случайных целых чисел из отрезка [10;99].
Вывести массив на экран.
int[][] matrix = new int[4][5];
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
    }
    System.out.println();
}
int[][] array = new int[4][5];
// ref -> 0 0 0 0 0
// ref -> 0 0 0 0 0
// ref -> 0 0 0 0 0
// ref -> 0 0 0 0 0
 */
public class Task14 {
    private final ArrayHelper helper = new ArrayHelper();
    public void printResult() {
        int[][] matrix = new int[8][5];

        fillArraysWithRandomNumbers(matrix);

        printArrays(matrix);
    }

    private void fillArraysWithRandomNumbers(final int[][] matrix) {
        for (int[] ints : matrix) {
            helper.fillArrayWithRandomNumbers(ints, generator -> generator.nextInt(90) + 10);
        }
    }

    private void printArrays(final int[][] matrix) {
        for (int[] ints : matrix) {
            helper.printArray(ints);
            System.out.println();
        }
    }
}
