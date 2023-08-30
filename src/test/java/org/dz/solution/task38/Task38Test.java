package org.dz.solution.task38;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Task38Test {

    @Test
    public void test() {
        Assert.assertTrue(isAnagram("нора", "рано"));
        Assert.assertTrue(isAnagram("сосна", "насос"));
        Assert.assertFalse(isAnagram("hello", "bye"));
        Assert.assertFalse(isAnagram("abc", "qwe"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

}