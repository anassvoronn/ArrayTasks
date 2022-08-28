package org.dz.solution;

/*
Создайте массив из 20-ти первых чисел
Фибоначчи и выведите его на экран.
Напоминаем, что первый и второй члены
последовательности равны единицам,
а каждый следующий — сумме двух предыдущих.
 */
public class Task7 {
    public void printResult() {
        int[] array = new int[20];

        getFibonacciArray(array);

        printArray(array);
    }

    private void getFibonacciArray(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < 2) {
                array[i] = 1;
            } else {
                array[i] = array[i - 2] + array[i - 1];
            }
        }
    }

    private void printArray(final int[] array) {
        for (int item : array) {
            System.out.println(item + " ");
        }
    }
}
