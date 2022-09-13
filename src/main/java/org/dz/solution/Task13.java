package org.dz.solution;

import java.util.Random;
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

            int evenElement = 0;
            int[] array1 = new int[number];
            Random generator = new Random();
            for (int i = 0; i < array1.length; i++) {
                array1[i] = generator.nextInt(number) + 1;
                System.out.print(array1[i] + " ");
                if (array1[i] % 2 == 0) {
                    evenElement++;
                }
            }

            System.out.println();

            if (evenElement != 0) {
                int[] array2 = new int[evenElement];
                evenElement = 0;
                for (int j : array1) {
                    if (j % 2 == 0) {
                        array2[evenElement] = j;
                        System.out.print(array2[evenElement] + " ");
                        evenElement++;
                    }
                }
                System.out.println();
            }
        }
    }
}
