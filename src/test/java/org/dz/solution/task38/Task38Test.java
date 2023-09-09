package org.dz.solution.task38;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Task38Test {

    @Test
    public void test() {
        Assert.assertFalse(isAnagram("abc", "qwe"));
        Assert.assertTrue(isAnagram("aacc", "ccac"));
        Assert.assertTrue(isAnagram("нора", "рано"));
        Assert.assertFalse(isAnagram("ab", "a"));
        Assert.assertTrue(isAnagram("сосна", "насос"));
        Assert.assertFalse(isAnagram("hello", "bye"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            Integer counter = map.get(c);
            if (counter == null || counter == 0) {
                return false;
            }
            map.put(c, counter - 1);
        }
        return true;
    }

}