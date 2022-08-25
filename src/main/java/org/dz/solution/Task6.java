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
    public void printResult(){
        int[] array = new int[4];

        fillArrayWithRandomNumbers(array);

        printStrictlyIncreasingArray(array);
    }
    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generation = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generation.nextInt(90) + 10;
            System.out.println(array[i] + " ");
        }
    }
    private void printStrictlyIncreasingArray(final int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i > 0){
                if (array[i - 1] >= array[i]){
                    System.out.println("Не возрастающая");
                    break;
                }
            }
            if (i == array.length - 1){
                System.out.println("Строго возрастающая");

            }

        }
    }
}
