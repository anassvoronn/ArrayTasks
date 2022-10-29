package org.dz.solution;

import java.util.Random;

/*
Создать двумерный массив из 6 строк по 7 столбцов в
каждой из случайных целых чисел из отрезка [0;9].
Вывести массив на экран. Преобразовать массив таким
образом, чтобы на первом месте в каждой строке стоял
её наибольший элемент. При этом изменять состав массива
нельзя, а можно только переставлять элементы в рамках одной строки.
Порядок остальных элементов строки не важен (т.е. можно
соврешить только одну перестановку, а можно отсортировать
по убыванию каждую строку). Вывести преобразованный массив на экран.
 */
public class Task17 {
    public void printResult() {
        int[][] array = new int[6][7];

        fillArraysWithRandomNumbers(array);
        printArray(array);

        System.out.println();

        convertArray(array);

        System.out.println();

        printArray(array);
    }

    private void fillArraysWithRandomNumbers(final int[][] array) {
        for (int i = 0; i < array.length; i++) {
            Random generator = new Random();
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generator.nextInt(10);
            }
        }
    }

    private void printArray(final int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private void convertArray(final int[][] matrix) {
        for (int[] row : matrix) {
            int maxNumberIndex = getIndexOfMaxNumberInRow(row);
            swap(row, maxNumberIndex);
        }
    }

    private int getIndexOfMaxNumberInRow(final int[] row) {
        int max = row[0];
        int maxNumberIndex = 0;
        for (int j = 0; j < row.length; j++) {
            if (row[j] > max) {
                max = row[j];
                maxNumberIndex = j;
            }
        }
        return maxNumberIndex;
    }

    private void swap(final int[] row, int maxNumberIndex) {
        int temp = row[0];
        row[0] = row[maxNumberIndex];
        row[maxNumberIndex] = temp;
    }
}
