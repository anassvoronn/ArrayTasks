package org.dz.solution.task29;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void testConstructor() {
        MyArrayList list = new MyArrayList();
        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void add() {
        MyArrayList list = new MyArrayList();
        boolean result = list.add(10);
        Assert.assertTrue(result);
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
    }

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
        Assert.assertEquals(6, list.getCapacity());
        Assert.assertEquals(4, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(Integer.valueOf(-10), list.get(2));
        Assert.assertEquals(Integer.valueOf(120), list.get(3));
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void add_8MoreElements() {
        MyArrayList list = new MyArrayList();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));
        Assert.assertEquals(12, list.getCapacity());
        Assert.assertEquals(8, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(Integer.valueOf(-10), list.get(2));
        Assert.assertEquals(Integer.valueOf(120), list.get(3));
        Assert.assertEquals(Integer.valueOf(27), list.get(4));
        Assert.assertEquals(Integer.valueOf(-60), list.get(5));
        Assert.assertEquals(Integer.valueOf(1), list.get(6));
        Assert.assertEquals(Integer.valueOf(0), list.get(7));
        Assert.assertFalse(list.isEmpty());

    }

    @Test
    public void size() {
        MyArrayList list = new MyArrayList();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertEquals(12, list.getCapacity());
        Assert.assertEquals(8, list.size());
    }

    @Test
    public void contains_withBigList() {
        MyArrayList list = new MyArrayList();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertEquals(8, list.size());

        Assert.assertTrue(list.contains(5));
        Assert.assertTrue(list.contains(0));
        Assert.assertTrue(list.contains(-10));
        Assert.assertTrue(list.contains(120));
        Assert.assertTrue(list.contains(27));
        Assert.assertTrue(list.contains(-60));
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(0));

        Assert.assertFalse(list.contains(-5));
        Assert.assertFalse(list.contains(10000));
        Assert.assertFalse(list.contains(10));
        Assert.assertFalse(list.contains(-120));
        Assert.assertFalse(list.contains(-27));
        Assert.assertFalse(list.contains(60));
        Assert.assertFalse(list.contains(-1));
        Assert.assertFalse(list.contains(10000000));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_removedIndexOutOfBoundsException() {
        MyArrayList list = new MyArrayList();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertEquals(Integer.valueOf(-60), list.get(4));
        Assert.assertEquals(Integer.valueOf(1), list.get(5));
        Assert.assertEquals(6, list.size());
        Assert.assertEquals(12, list.getCapacity());
        list.get(6);
    }

    @Test
    public void remove_removedSomeElementsOfTheList() {
        MyArrayList list = new MyArrayList();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertEquals(7, list.size());
        Assert.assertTrue(list.contains(0));
        Assert.assertEquals(Integer.valueOf(-10), list.get(1));

        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertEquals(6, list.size());
        Assert.assertFalse(list.contains(0));
        Assert.assertEquals(Integer.valueOf(1), list.get(5));

        Assert.assertEquals(12, list.getCapacity());
    }

    @Test
    public void remove_removedAllElementsOfTheList() {
        MyArrayList list = new MyArrayList();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertFalse(list.remove(Integer.valueOf(-5)));
        Assert.assertFalse(list.remove(Integer.valueOf(10000)));
        Assert.assertFalse(list.remove(Integer.valueOf(10)));
        Assert.assertFalse(list.remove(Integer.valueOf(-120)));
        Assert.assertEquals(8, list.size());

        Assert.assertTrue(list.remove(Integer.valueOf(5)));
        Assert.assertEquals(7, list.size());
        Assert.assertEquals(7, list.size());
        Assert.assertFalse(list.contains(5));
        Assert.assertEquals(Integer.valueOf(0), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertEquals(6, list.size());
        Assert.assertTrue(list.contains(0));
        Assert.assertEquals(Integer.valueOf(-10), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(-10)));
        Assert.assertEquals(5, list.size());
        Assert.assertFalse(list.contains(-10));
        Assert.assertEquals(Integer.valueOf(120), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(120)));
        Assert.assertEquals(4, list.size());
        Assert.assertFalse(list.contains(120));
        Assert.assertEquals(Integer.valueOf(27), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(27)));
        Assert.assertEquals(3, list.size());
        Assert.assertFalse(list.contains(27));
        Assert.assertEquals(Integer.valueOf(-60), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(-60)));
        Assert.assertEquals(2, list.size());
        Assert.assertFalse(list.contains(-60));
        Assert.assertEquals(Integer.valueOf(1), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(1)));
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.contains(1));
        Assert.assertEquals(Integer.valueOf(0), list.get(0));

        Assert.assertTrue(list.remove(Integer.valueOf(0)));
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(0));

        Assert.assertFalse(list.remove(Integer.valueOf(-27)));
        Assert.assertFalse(list.remove(Integer.valueOf(60)));
        Assert.assertFalse(list.remove(Integer.valueOf(-1)));
        Assert.assertFalse(list.remove(Integer.valueOf(10000000)));

        Assert.assertEquals(0, list.size());
        Assert.assertEquals(12, list.getCapacity());
    }

    @Test
    public void test1_3_6_7_when_remove_6() {
        MyArrayList list = new MyArrayList();

        list.add(1);
        list.add(3);
        list.add(6);
        list.add(7);
        list.remove(Integer.valueOf(6));
        Assert.assertEquals(6, list.getCapacity());
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        Assert.assertEquals(Integer.valueOf(3), list.get(1));
        Assert.assertEquals(Integer.valueOf(7), list.get(2));
    }

    @Test
    public void test1_3_6_when_remove_3() {
        MyArrayList list = new MyArrayList();

        list.add(1);
        list.add(3);
        list.add(6);
        list.remove(Integer.valueOf(3));
        Assert.assertEquals(3, list.getCapacity());
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        Assert.assertEquals(Integer.valueOf(6), list.get(1));
    }
}
