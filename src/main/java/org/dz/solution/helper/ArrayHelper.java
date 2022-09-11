package org.dz.solution.helper;

import java.util.Random;

public class ArrayHelper {

    public void printArray(final int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    public void fillArrayWithRandomNumbers(final int[] array, final RandomNumberProvider provider) {
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = provider.provideInt(generator);
        }
    }

    public interface RandomNumberProvider {
        int provideInt(Random generator);
    }
}
