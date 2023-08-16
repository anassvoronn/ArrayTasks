package org.dz.solution.task34;

import org.junit.Assert;
import org.junit.Test;

public class Task34Test {

    @Test
    public void test1() {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = {0, 1};
        Assert.assertEquals(result, twoSum(array, target));
    }

    public int[] twoSum(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        while (min < max){
            int currentSum = array[min] + array[max];
            if(currentSum == target){
                return new int[]{min, max};
            }
            min++;
        }
        return new int[]{};
    }
}