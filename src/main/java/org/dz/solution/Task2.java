package org.dz.solution;

/*
Создайте массив из всех нечётных чисел от 1 до n,
выведите его на экран в строку, а затем этот же
массив выведите на экран тоже в строку, но в
обратном порядке (n... 97 95 93 … 7 5 3 1).
 */
public class Task2 {
    public int[] getOddNumbers(final int number) {
        int[] resultArray = new int[getArrayLength(number)];
        int index = 0;
        for (int i = number; i >= 1; i--) {
            if (isOddNumber(i)) {
                resultArray[index] = i;
                index++;
            }
        }
        return resultArray;
    }

    private boolean isOddNumber(final int number) {
        return number % 2 != 0;
    }

    private int getArrayLength(final int number) {
        int arrayLength = number / 2;
        if (isOddNumber(number)) {
            arrayLength += 1;
        }
        return arrayLength;
    }
}
