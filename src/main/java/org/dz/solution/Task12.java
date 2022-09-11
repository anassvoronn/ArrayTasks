package org.dz.solution;

import org.dz.solution.helper.ArrayHelper;

import java.util.Random;

/*
Программа должна создать массив из 12 случайных
целых чисел из отрезка [-10;10] таким образом,
чтобы отрицательных и положительных элементов там
было поровну и не было нулей. При этом порядок
следования элементов должен быть случаен (т. е. не
подходит вариант, когда в массиве постоянно выпадает
сначала 6 положительных, а потом 6 отрицательных чисел
или же когда элементы постоянно чередуются через один
и пр.). Вывести полученный массив на экран.
 */
public class Task12 {
    public void printResult() {
        int[] array = new int[6];

        fillArrayWithRandomNumbers(array);

        ArrayHelper helper = new ArrayHelper();
        helper.printArray(array);
    }

    private void fillArrayWithRandomNumbers(final int[] array) {
        Random generator = new Random();
        int positiveNumbersCounter = 0;
        int negativeNumbersCounter = 0;
        int halfArrayLength = array.length / 2;

        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(21) - 10;
            if (array[i] == 0) {
                i--;
                continue;
            }
            if (array[i] < 0) {
                if (negativeNumbersCounter == halfArrayLength) {
                    i--;
                    continue;
                }
                negativeNumbersCounter++;
            } else {
                if (positiveNumbersCounter == halfArrayLength) {
                    i--;
                    continue;
                }
                positiveNumbersCounter++;
            }
        }
    }
}