package org.dz.solution;

import java.util.Random;

/*
Создайте массив из 12 случайных целых чисел
из отрезка [-15;15]. Определите какой элемент
является в этом массиве максимальным и сообщите
индекс его последнего вхождения в массив.
[-13, -7, 5, 0, 5, -13]
 */
public class Task8 {
    public void printArray() {
        int[] array = new int[12];

        fillArrayWithRandomNumbers(array);

        printArray(array);
        System.out.println();
        determineTheMaxElementInAnArray(array);
    }

    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(31) - 15;
        }
    }

    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    private void determineTheMaxElementInAnArray(final int[] array) {
        int maxNumber = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= maxNumber) {
                maxNumber = array[i];
                index = i;
            }
        }
        System.out.println(array[index] + " Max Element");
        System.out.println(index + " Index");
    }
}
