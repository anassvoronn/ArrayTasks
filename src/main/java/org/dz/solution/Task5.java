package org.dz.solution;

import java.util.Random;

/*
Создайте 2 массива из 5 случайных целых чисел
из отрезка [0;5] каждый, выведите массивы на
экран в двух отдельных строках. Посчитайте
среднее арифметическое элементов каждого
массива и сообщите, для какого из массивов
это значение оказалось больше
(либо сообщите, что их средние арифметические равны).
 */
public class Task5 {
    public void printResult() {
        int[] array1 = new int[5];
        int[] array2 = new int[5];

        fillArrayWithRandomNumbers(array1);
        fillArrayWithRandomNumbers(array2);

        printArray(array1);
        System.out.println();
        printArray(array2);
        System.out.println();

        double averageArray1 = getAverage(array1);
        System.out.println("Array1 " + averageArray1);
        double averageArray2 = getAverage(array2);
        System.out.println("Array2 " + averageArray2);

        if (averageArray1 > averageArray2) {
            System.out.println("Array1 > Array2");
            return;
        }
        if (averageArray1 < averageArray2) {
            System.out.println("Array2 < Array1");
            return;
        }
        System.out.println("Array1 == Array2");

    }

    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(6);
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private double getAverage(final int[] array) {
        double result = 0;
        for (int number : array) {
            result = result + number;
        }
        return result / 5;
    }
}
