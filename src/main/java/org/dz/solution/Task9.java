package org.dz.solution;

import java.util.Random;

/*
Создайте два массива из 10 целых случайных
чисел из отрезка [1;9] и третий массив из
10 действительных чисел (это значит массив
double чисел не int[] а double[] ). Каждый
элемент с i-ым индексом третьего массива
должен равняться отношению(отношение это
деление) элемента из первого массива с i-ым
индексом к элементу из второго массива
с i-ым индексом. Вывести все три массива
на экран (каждый на отдельной строке),
затем вывести количество целых элементов
в третьем массиве. Сначала заполняешь первые
два массива, а уже потом в отдельном методе
заполняешь 3ий. В этот метод нужно будет
передать 2 первых массива.
 */
public class Task9 {
    private final int ARRAY_LENGTH = 5;

    public void printTaskResults() {
        int[] array1 = new int[ARRAY_LENGTH];
        int[] array2 = new int[ARRAY_LENGTH];

        fillArraysWithRandomNumbers(array1);
        fillArraysWithRandomNumbers(array2);

        printArray(array1);
        System.out.println();
        printArray(array2);

        double[] array3 = createTheThirdArray(array1, array2);
        System.out.println();
        printArray(array3);

        System.out.println();
        System.out.println(getQuantityOfIntegers(array3));

    }

    private void fillArraysWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(9) + 1;
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private double[] createTheThirdArray(final int[] array1, final int[] array2) {
        double[] array3 = new double[ARRAY_LENGTH];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = (double) array1[i] / array2[i];
        }
        return array3;
    }

    private void printArray(final double[] array) {
        for (double j : array) {
            System.out.print(j + " ");
        }
    }

    private int getQuantityOfIntegers(final double[] array) {
        int quantity = 0;
        for (double number : array) {
            if (Math.floor(number) == number) {
                quantity++;
            }
        }
        return quantity;
    }
}
