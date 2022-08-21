package org.dz.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void getOddNumbers20() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(20);
        Assert.assertArrayEquals(new int[]{19, 17, 15, 13, 11, 9, 7, 5, 3, 1}, result);
    }

    @Test
    public void getOddNumbers2() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(2);
        Assert.assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void getOddNumbers4() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(4);
        Assert.assertArrayEquals(new int[]{3, 1}, result);
    }

    @Test
    public void getOddNumbers18() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(18);
        Assert.assertArrayEquals(new int[]{17, 15, 13, 11, 9, 7, 5, 3, 1}, result);
    }

    @Test
    public void getOddNumbers19() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(19);
        Assert.assertArrayEquals(new int[]{19, 17, 15, 13, 11, 9, 7, 5, 3, 1}, result);
    }

    @Test
    public void getOddNumbers3() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(3);
        Assert.assertArrayEquals(new int[]{3, 1}, result);
    }

    @Test
    public void getOddNumbers1() {
        Task2 task = new Task2();
        int[] result = task.getOddNumbers(1);
        Assert.assertArrayEquals(new int[]{1}, result);
    }
}