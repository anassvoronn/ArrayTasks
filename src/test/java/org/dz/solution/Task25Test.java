package org.dz.solution;

import org.dz.solution.helper.TestHelper;
import org.junit.Test;

public class Task25Test {
    @Test
    public void absMinus100() {
        int number = -100;
        int result = Math.abs(number);
        TestHelper.compareResult(100, result);
    }

    @Test
    public void absMinus1000000() {
        int number = -1000000;
        int result = Math.abs(number);
        TestHelper.compareResult(1000000, result);
    }

    @Test
    public void abs0() {
        int number = 0;
        int result = Math.abs(number);
        TestHelper.compareResult(0, result);
    }

    @Test(expected = RuntimeException.class)
    public void badTest() {
        int number = -10;
        int result = Math.abs(number) + 1;
        TestHelper.compareResult(10, result);
    }

    @Test
    public void floor7_8() {
        double number = 7.8;
        double result = Math.floor(number);
        TestHelper.compareResult(7.0, result);
    }

    @Test
    public void floor3_14() {
        double number = 3.14;
        double result = Math.floor(number);
        TestHelper.compareResult(3.0, result);
    }

    @Test
    public void floorMinus12_345() {
        double number = -12.345;
        double result = Math.floor(number);
        TestHelper.compareResult(-13.0, result);
    }

    @Test
    public void floorMinus98_1() {
        double number = -98.1;
        double result = Math.floor(number);
        TestHelper.compareResult(-99.0, result);
    }

    @Test
    public void floor0_1() {
        double number = 0.1;
        double result = Math.floor(number);
        TestHelper.compareResult(0, result);
    }
}
