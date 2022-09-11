package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

import java.util.Scanner;

/*
Пользователь должен указать с клавиатуры чётное
положительное число, а программа должна создать
массив указанного размера из случайных целых чисел
из [-5;5] и вывести его на экран в строку. После
этого программа должна определить и сообщить
пользователю о том, сумма модулей какой половины
массива больше: левой или правой, либо сообщить,
что эти суммы модулей равны. Если пользователь введёт
неподходящее число, то программа должна требовать повторного
ввода до тех пор, пока не будет указано корректное значение.
 */
public class Task11 {

    public static final String EXIT_KEY_WORD = "exit";

    public static void main(String[] args) {
        Task11 task11 = new Task11();
        task11.printResult();
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
            if (number <= 0) {
                System.out.println("Error: Non positive number '" + number + "'");
                continue;
            }
            if (number % 2 != 0) {
                System.out.println("Error: Odd number '" + number + "'");
                continue;
            }
            int[] array = new int[number];
            ArrayHelper helper = new ArrayHelper();
            helper.fillArrayWithRandomNumbers(array, generator -> generator.nextInt(11) - 5);
            helper.printArray(array);
            System.out.println();

            int leftSideArraySum = 0;
            int rightSideArraySum = 0;
            for (int i = 0; i < array.length; i++) {
                if (i <= array.length / 2 - 1) {
                    leftSideArraySum += Math.abs(array[i]);
                } else {
                    rightSideArraySum += Math.abs(array[i]);
                }
            }
            System.out.println();
            printResult(leftSideArraySum, rightSideArraySum);
        }
    }

    private void printResult(int leftSideArraySum, int rightSideArraySum) {
        if (leftSideArraySum > rightSideArraySum) {
            System.out.println("Сумма первой половины массива больше и равна " + leftSideArraySum);
        } else if (rightSideArraySum > leftSideArraySum) {
            System.out.println("Сумма второй половины массива больше и равна " + rightSideArraySum);
        } else {
            System.out.println("Суммы первой и второй половины равны");
        }
    }
}



