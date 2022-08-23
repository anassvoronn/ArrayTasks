package org.dz.solution;
/*
Создайте массив из 15 случайных целых
чисел из отрезка [0;9]. Выведите
массив на экран. Подсчитайте сколько в
массиве чётных элементов и выведете
это количество на экран на отдельной строке.
Пример:
[2,7,4,9,1,0,4,8,5,7,3,9,1,7,4]
6
 */

import java.util.Random;

public class Task3 {
    public void printResult() {
        int[] array = new int[15];
        populateArrayWithRandomNumbers(array);

        printArray(array);

        System.out.println();

        int evenNumberAmount = getEvenNumberAmount(array);

        System.out.println();
        System.out.print(evenNumberAmount);
    }

    private void populateArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(10);
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private int getEvenNumberAmount(final int[] array) {
        int evenNumberAmount = 0;
        for (int item : array) {
            if (item % 2 == 0) {
                evenNumberAmount++;
            }
        }
        return evenNumberAmount;
    }
}
