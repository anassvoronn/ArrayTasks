package org.dz.solution;

import java.util.Random;

/*
Создайте массив из 4 случайных целых
чисел из отрезка [10;99], выведите
его на экран в строку. Определить
и вывести на экран сообщение о том,
является ли массив строговозрастающей последовательностью.
 */
public class Task6 {
    public void printResult() {
        int[] array = new int[4];

        fillArrayWithRandomNumbers(array);

        printArray(array);

        check(array);
    }

    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generation = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generation.nextInt(100) + 10;
        }
    }

    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.println(item + " ");
        }
    }

    private boolean check(final int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i]) {
                return true;
            }
        }
        return false;
    }
}
