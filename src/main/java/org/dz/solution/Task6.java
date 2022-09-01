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

        if (isStrictlyIncreasing(array)){
            System.out.println("Строго возрастающий");
        }else {
            System.out.println("Не возрастающий");
        }
    }

    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(90) + 10;
        }
    }

    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.println(item + " ");
        }
    }

    boolean isStrictlyIncreasing(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] <= array[i]) {
                return false;
            }
        }
        return true;
    }
}
