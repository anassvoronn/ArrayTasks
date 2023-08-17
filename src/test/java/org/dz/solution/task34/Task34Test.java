package org.dz.solution.task34;

import org.junit.Assert;
import org.junit.Test;

public class Task34Test {

    @Test
    public void test1() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void test2() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{3, 2, 4}, 6);
        Assert.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void test3() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{3, 3}, 6);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void test4() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{13, 45, 1, 60, 88, 4}, 89);
        Assert.assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void test5() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{45, 2, -13, 0, 97, 1}, 84);
        Assert.assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void test6() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{-4, 0, 2, 55, 7}, -4);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void test7() {
        Task34Test task34 = new Task34Test();
        int[] result = task34.twoSum(new int[]{0, 0, 0}, 0);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    public int[] twoSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                if (currentSum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}