package org.dz.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {
    @Test
    public void getEvenNumbers20() {
        Task1 task = new Task1();
        int[] result = task.getEvenNumbers(20);
        Assert.assertArrayEquals(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, result);
    }

    @Test
    public void getEvenNumbers2() {
        Task1 task = new Task1();
        int[] result = task.getEvenNumbers(2);
        Assert.assertArrayEquals(new int[]{2}, result);
    }

    @Test
    public void getEvenNumbers3() {
        Task1 task = new Task1();
        int[] result = task.getEvenNumbers(3);
        Assert.assertArrayEquals(new int[]{2}, result);
    }

}