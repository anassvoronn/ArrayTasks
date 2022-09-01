package org.dz.solution;

import org.junit.Assert;
import org.junit.Test;

public class Task6Test {

    @Test
    public void printResult() {
        Task6 task6 = new Task6();
        task6.printResult();
    }

    @Test
    public void isStrictlyIncreasingCase1() {
        Task6 task6 = new Task6();
        boolean result = task6.isStrictlyIncreasing(new int[]{10, 23, 47, 68});
        Assert.assertTrue(result);
    }

    @Test
    public void isStrictlyIncreasingCase2() {
        Task6 task6 = new Task6();
        boolean result = task6.isStrictlyIncreasing(new int[]{10, 23, 23, 47, 68});
        Assert.assertFalse(result);
    }

    @Test
    public void isStrictlyIncreasingCase3() {
        Task6 task6 = new Task6();
        boolean result = task6.isStrictlyIncreasing(new int[]{10, -1, -13, -25});
        Assert.assertFalse(result);
    }
}