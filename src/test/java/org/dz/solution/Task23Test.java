package org.dz.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task23Test {

    @Test
    public void searchingForAnElementInAnArray13() {
        Task23 task = new Task23();
        int result = task.useBinarySearch1(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 2, 20, 13);
        Assert.assertEquals(-1, 13);
    }

    @Test
    public void searchingForAnElementInAnArray50() {
        Task23 task = new Task23();
        int result = task.useBinarySearch1(new int[]{2, 9, 11, 14, 21, 39, 40, 44, 50, 65}, 2, 65, 50);
        Assert.assertArrayEquals();
    }

    @Test
    public void searchingForAnElementInAnArray7() {
        Task23 task = new Task23();
        int result = task.useBinarySearch1(new int[]{}, 7, 7, 7);
        Assert.assertArrayEquals();
    }

}