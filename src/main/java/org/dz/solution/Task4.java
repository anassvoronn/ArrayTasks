package org.dz.solution;

import java.util.Random;

/*
Создайте массив из 8 случайных целых чисел
из отрезка [1;10]. Выведите массив на экран
в строку. Замените каждый элемент с нечётным
индексом на ноль. Снова выведете
массив на экран на отдельной строке.
 */
public class Task4 {
    public void printResult() {
        int[] array = new int[8];

        populateArrayWithRandomNumbers(array);

        System.out.println();

        getZeroWithOddIndex(array);
    }

    private void populateArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(10) + 1;
        }
    }

    private void getZeroWithOddIndex(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
    }

}

