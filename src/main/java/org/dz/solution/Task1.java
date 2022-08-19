package org.dz.solution;

/*
Создайте массив из всех чётных чисел от 2 до 20
и выведите элементы массива на экран сначала в
строку, отделяя один элемент от другого пробелом,
а затем в столбик (отделяя один элемент от другого
началом новой строки).
Перед созданием массива подумайте, какого он будет размера.
 */
public class Task1 {
    public int[] getEvenNumbers(final int number) {
        int index = 0;
        int[] resultArray = new int[number / 2];
        for (int i = 2; i <= number; i++) {
            if (i % 2 == 0) {
                resultArray[index] = i;
                index++;
            }
        }
        return resultArray;
    }

}
