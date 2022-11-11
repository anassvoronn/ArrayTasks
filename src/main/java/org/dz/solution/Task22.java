package org.dz.solution;

import java.util.Random;

/*
Напиши МЕТОД который принимает матрицу
размером a на b (генерируй рендомно),
потом транспонирует ее. потом выводи на ее экран.
 */
public class Task22 {
    public void printResult() {
        int[][] matrix = new int[2][5];
        int[][] transportMatrix = new int[5][2];
        fillArraysWithRandomNumbers(matrix);
        printArray(matrix);

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transportMatrix[j][i] = matrix[i][j];
            }
        }
        printArray(transportMatrix);
    }

    private void fillArraysWithRandomNumbers(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Random generator = new Random();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = generator.nextInt(10);
            }
        }
    }

    private void printArray(final int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
