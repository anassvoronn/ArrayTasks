package org.dz.solution;

import org.dz.solution.task21prep.Car;

public class Task21 {

    public void sort(final Car[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getPrice() > array[j].getPrice()) {
                    Car temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
