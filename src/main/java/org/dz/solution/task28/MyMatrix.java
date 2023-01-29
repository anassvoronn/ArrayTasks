package org.dz.solution.task28;

import java.util.Random;

public class MyMatrix {
    private int[][] array;
    private final Random generator = new Random();

    public MyMatrix(int linesNumber, int columnsNumber) {
        array = new int[linesNumber][columnsNumber];
    }

    public MyMatrix(int linesNumber, int columnsNumber, boolean randomMatrix) {
        this(linesNumber, columnsNumber);
        if (randomMatrix) {
            generateRandomMatrix();
        }
    }

    private void generateRandomMatrix() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generator.nextInt(10);
            }
        }
    }

    public void addNumber(int number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *= number;
            }
        }
    }

    public void printMatrix() {
        for (int[] matrix : array) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "1 4 2\n3 7 9";
    }

    public void addMatrix(MyMatrix otherMatrix) {
        int[][] array2 = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

            }

        }
    }

    /*
    Сделать не для квадратных матриц

    посмотреть видео
     */
    public void transpose() {
        int[][] resultArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                int temp = resultArray[i][j];
                resultArray[i][j] = resultArray[j][i];
                resultArray[j][i] = temp;
            }
        }
        array = resultArray;
    }
}
