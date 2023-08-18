package org.dz.solution.task35;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

public class Task35Test {

    @Test
    public void test1() {
        boolean result = containsDuplicate(new int[]{1, 2, 3, 4});
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        boolean result = containsDuplicate(new int[]{1, 2, 3, 1});
        Assert.assertTrue(result);
    }

    @Test
    public void test3() {
        boolean result = containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = containsDuplicate(new int[]{0, 0, 0});
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        boolean result = containsDuplicate(new int[]{1});
        Assert.assertFalse(result);
    }


    @Test
    public void test6() {
        boolean result = containsDuplicate(new int[]{-1, 2, 3, -1});
        Assert.assertTrue(result);
    }

    @Test
    public void test7() {
        boolean result = containsDuplicate(new int[]{});
        Assert.assertFalse(result);
    }

    public boolean containsDuplicate(int[] nums) {
        Collection<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                continue;
            }
            return true;
        }
        return false;
    }
}