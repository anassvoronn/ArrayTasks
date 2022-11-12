package org.dz.solution;

import org.dz.solution.task24prep.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
 * 1) Почитай вчем разница между Integer и int
 * 2) Написать метод size и isEmpty
 */
public class Task24Test {

    @Test
    public void testAddOneElementAndCheckGetThenSizeThenIsEmpty() {
        final List<Integer> list = new ArrayList<>();
        assertTrue(list.add(5));
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(1, list.size());
        assertFalse(list.isEmpty());

        final List<Integer> myList = new MyArrayList();
        assertTrue(myList.add(5));
        Assert.assertEquals(Integer.valueOf(5), myList.get(0));
        Assert.assertEquals(1, myList.size());
        assertFalse(myList.isEmpty());
    }

}