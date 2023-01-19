package org.dz.solution;

import org.junit.Assert;
import org.junit.Test;

public class Task23Test {

    @Test
    public void searchingForAnElementInAnArray13() {
        Task23 task = new Task23();
        int result = task.useBinarySearchRecursively(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 13);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void searchingForAnElementInAnArray50() {
        Task23 task = new Task23();
        int result = task.useBinarySearchRecursively(new int[]{2, 9, 11, 14, 21, 39, 40, 44, 50, 65}, 50);
        Assert.assertEquals(8, result);
    }

    @Test
    public void searchingForAnElementInAnArray7() {
        Task23 task = new Task23();
        int result = task.useBinarySearchRecursively(new int[]{}, 7);
        Assert.assertEquals(-1, result);
    }
}