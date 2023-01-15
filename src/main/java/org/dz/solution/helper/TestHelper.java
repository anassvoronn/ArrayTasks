package org.dz.solution.helper;

public class TestHelper {
    public static void compareResult(int expected, int actual) {
        if (expected == actual) {
            return;
        }
        fail(expected, actual);
    }

    private static String format(String expected, String actual) {
        return "Expected result '" + expected + "' != actual result '" + actual + "'";
    }

    public static void compareResult(double expected, double actual) {
        if (expected != actual) {
            fail(expected, actual);
        }
    }

    private static void fail(double expected, double actual) {
        throw new RuntimeException(format(String.valueOf(expected), String.valueOf(actual)));
    }
}
