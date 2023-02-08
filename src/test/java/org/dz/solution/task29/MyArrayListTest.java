package org.dz.solution.task29;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void testConstructor() {
        MyArrayList list = new MyArrayList();
        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
        Assert.assertNull(list.get(0));
    }

    @Test
    public void add() {
        MyArrayList list = new MyArrayList();
        boolean result = list.add(10);
        Assert.assertTrue(result);
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
        Assert.assertNull(list.get(1));
    }

    //Дописать этот тест
    @Test
    public void add_3MoreElements() {
        MyArrayList list = new MyArrayList();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(Integer.valueOf(-10), list.get(2));
        Assert.assertFalse(list.isEmpty());

    }

    @Test
    public void add_2MoreElements() {
        MyArrayList list = new MyArrayList();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertFalse(list.isEmpty());
    }


    @Test
    public void add_4MoreElements() {
        MyArrayList list = new MyArrayList();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(Integer.valueOf(-10), list.get(2));
        Assert.assertEquals(Integer.valueOf(120), list.get(3));
        Assert.assertFalse(list.isEmpty());
    }

}
