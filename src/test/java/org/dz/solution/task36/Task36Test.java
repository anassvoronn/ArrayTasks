package org.dz.solution.task36;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Task36Test {

    @Test
    public void test1() {
        int result = numJewelsInStones("aA", "aAAbbbb");
        Assert.assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = numJewelsInStones("z", "ZZ");
        Assert.assertEquals(0, result);
    }

    @Test
    public void test3() {
        int result = numJewelsInStones("", "ZZzzzzzzz");
        Assert.assertEquals(0, result);
    }

    @Test
    public void test4() {
        int result = numJewelsInStones("ASDFGHJKL", "ASDFGHJKL");
        Assert.assertEquals(9, result);
    }

    @Test
    public void test5() {
        int result = numJewelsInStones("QqBPR", "QtqBasdfhjkPwsdfR");
        Assert.assertEquals(5, result);
    }

    @Test
    public void test6() {
        int result = numJewelsInStones("", "");
        Assert.assertEquals(0, result);
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}