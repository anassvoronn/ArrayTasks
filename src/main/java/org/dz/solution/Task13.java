package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

import java.util.Scanner;

/*
Пользователь вводит с клавиатуры натуральное число
большее 3, которое сохраняется в переменную n.
Если пользователь ввёл не подходящее число, то
программа должна просить пользователя повторить ввод.
Создать массив из n случайных целых чисел из отрезка
[0;n] и вывести его на экран. Создать второй массив только
из чётных элементов первого массива, если они там есть,
и вывести его на экран.
 */
public class Task13 {

    public static final String EXIT_KEY_WORD = "exit";

    public static void main(String[] args) {
        Task13 task13 = new Task13();
        task13.printResult();
    }

    public void printResult() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number...");
            int number;
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                String enteredText = scanner.nextLine();
                if (EXIT_KEY_WORD.equals(enteredText)) {
                    System.out.println("Program is going to be closed");
                    break;
                }
                System.out.println("Error: Bad number '" + enteredText + "'");
                continue;
            }
            if (number < 0) {
                System.out.println("Error: This is not a natural number '" + number + "'");
                continue;
            }
            if (number < 3) {
                System.out.println("Error: You need to enter a number greater than 3");
                continue;
            }

            int[] array1 = new int[number];
            ArrayHelper helper = new ArrayHelper();
            helper.fillArrayWithRandomNumbers(array1, generator -> generator.nextInt(number + 1));
            helper.printArray(array1);
            System.out.println();

            final int evenNumbersQuantity = getNumberOfEvenNumbers(array1);

            helper.printArray(createAndFillSecondArray(array1, evenNumbersQuantity));

            System.out.println();
        }
    }

    private int getNumberOfEvenNumbers(final int[] array) {
        int counter = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    private int[] createAndFillSecondArray(final int[] array1, final int evenNumbersQuantity) {
        int index = 0;
        int[] array2 = new int[evenNumbersQuantity];
        for (int j : array1) {
            if (j % 2 == 0) {
                array2[index] = j;
                index++;
            }
        }
        return array2;
    }
}
