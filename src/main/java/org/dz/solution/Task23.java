package org.dz.solution;

import java.util.Arrays;
import java.util.Random;

/*
Напишите метод, который проверяет,
входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для
решения этой задачи. Сравните время выполнения
обоих решений для больших массивов (например, 100000000 элементов).
 */
public class Task23 {
    public void printResult() {
        int[] array = new int[10];
        int elementToSearch = 13;

        fillArraysWithRandomNumbers(array);
        Arrays.sort(array);
        printArray(array);

        System.out.println();
        int i = useBinarySearch(array, elementToSearch);
        System.out.print(i);
    }

    private void fillArraysWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(70);
        }
    }

    private void printArray(final int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private int useBinarySearch(final int[] array, final int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            } else if (array[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            }
        }
        return elementToSearch;
    }

    private int useBinarySearch1(final int[] array, final int firstIndex, final int lastIndex, final int elementToSearch) {
        if (lastIndex >= firstIndex) {
            int middle = firstIndex + (lastIndex - firstIndex) / 2;
            if (array[middle] == elementToSearch) {
                return middle;
            }
            if (array[middle] > elementToSearch) {
                return useBinarySearch1(array, firstIndex, middle - 1, elementToSearch);
            }else if (array[middle] < elementToSearch){
                return useBinarySearch1(array, middle + 1, lastIndex, elementToSearch);
            }
        }
        return -1;
    }
}

