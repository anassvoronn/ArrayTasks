package org.dz.solution.task28;

import java.util.Arrays;
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

    public MyMatrix(int[][] sourceArray) {
        array = sourceArray;
        //TODO Нарушение Инкапсуляции
    }

    private void generateRandomMatrix() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generator.nextInt(10);
            }
        }
    }

    public void multiplyBy(int number) {
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                stringBuilder.append(array[i][j]);
                if (j < array[i].length - 1){
                    stringBuilder.append(" ");
                }
            }
            if (i < array.length - 1){
                stringBuilder.append("\n");
            }

        }
        return stringBuilder.toString();
    }

    public MyMatrix clone() {
        int[][] newArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, array[i].length);
        }
        return new MyMatrix(newArray);
    }

    //TODO Написать тест для метода
    public void addMatrix(MyMatrix otherMatrix) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = array[i][j] + otherMatrix.array[i][j];
            }
        }
    }


    public void transpose() {
        int[][] resultArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[j][i] = array[i][j];
            }
        }
        array = resultArray;
    }

    public int getLinesNumber() {
        return array.length;
    }

    public int getColumnsNumber() {
        return array[0].length;
    }

    public int get(final int line, final int column) {
        return array[line][column];
    }

    public void fillWith(final int number) {
        for (int[] line : array) {
            Arrays.fill(line, number);
        }
    }

}
