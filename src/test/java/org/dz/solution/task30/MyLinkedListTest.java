package org.dz.solution.task30;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MyLinkedListTest {
    @Test
    public void testConstructor() {
        List<Integer> list = new MyLinkedList<>();
        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void add() {
        List<Integer> list = new MyLinkedList<>();
        boolean result = list.add(10);
        Assert.assertTrue(result);
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(Integer.valueOf(10), list.get(0));
    }

    @Test
    public void add_3MoreElements() {
        List<Integer> list = new MyLinkedList<>();
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
        List<Integer> list = new MyLinkedList<>();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertFalse(list.isEmpty());
    }


    @Test
    public void add_4MoreElements() {
        List<Integer> list = new MyLinkedList<>();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertEquals(4, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(Integer.valueOf(-10), list.get(2));
        Assert.assertEquals(Integer.valueOf(120), list.get(3));
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void add_8MoreElements() {
        List<Integer> list = new MyLinkedList<>();
        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));
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
        List<Integer> list = new MyLinkedList<>();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertEquals(8, list.size());
    }

    @Test
    public void contains_withBigList() {
        List<Integer> list = new MyLinkedList<>();

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
        List<Integer> list = new MyLinkedList<>();

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
        list.get(6);
    }

    @Test
    public void remove_removedSomeElementsOfTheList() {
        List<Integer> list = new MyLinkedList<>();

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

    }

    @Test
    public void remove_removedAllElementsOfTheList() {
        List<Integer> list = new MyLinkedList<>();

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
    }

    @Test
    public void test1_3_6_7_when_remove_6() {
        List<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(3);
        list.add(6);
        list.add(7);
        list.remove(Integer.valueOf(6));
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        Assert.assertEquals(Integer.valueOf(3), list.get(1));
        Assert.assertEquals(Integer.valueOf(7), list.get(2));
    }

    @Test
    public void test1_3_6_when_remove_3() {
        List<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(3);
        list.add(6);
        list.remove(Integer.valueOf(3));
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        Assert.assertEquals(Integer.valueOf(6), list.get(1));
    }

    @Test
    public void clear_7MoreElements() {
        List<Integer> list = new MyLinkedList<>();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(500));
        Assert.assertTrue(list.add(4));
        Assert.assertTrue(list.add(-1));
        Assert.assertTrue(list.add(25));

        Assert.assertEquals(7, list.size());

        list.clear();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void clear_5MoreElements() {
        List<Integer> list = new MyLinkedList<>();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(500));
        Assert.assertTrue(list.add(4));

        Assert.assertEquals(5, list.size());

        list.clear();

        Assert.assertEquals(0, list.size());

        list.clear();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void remove_removedByIndexOutOfBoundsException() {
        List<Integer> list = new MyLinkedList<>();

        Assert.assertTrue(list.add(5));
        Assert.assertTrue(list.add(0));
        Assert.assertTrue(list.add(-10));
        Assert.assertTrue(list.add(120));
        Assert.assertTrue(list.add(27));
        Assert.assertTrue(list.add(-60));
        Assert.assertTrue(list.add(1));
        Assert.assertTrue(list.add(0));

        Assert.assertEquals(Integer.valueOf(120), list.remove(3));
        Assert.assertEquals(7, list.size());
        Assert.assertFalse(list.contains(120));
        Assert.assertEquals(Integer.valueOf(27), list.get(3));

        Assert.assertEquals(Integer.valueOf(-60), list.remove(4));
        Assert.assertEquals(6, list.size());
        Assert.assertFalse(list.contains(-60));
        Assert.assertEquals(Integer.valueOf(1), list.get(4));

        Assert.assertEquals(6, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_0IndexFromEmptyArray() {
        List<Integer> list = new MyLinkedList<>();

        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_5IndexFromLength5Array() {
        List<Integer> list = new MyLinkedList<>();

        list.add(13);
        list.add(-6);
        list.add(0);
        list.add(200);
        list.add(0);

        list.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_minus1IndexFromLength5Array() {
        List<Integer> list = new MyLinkedList<>();

        list.add(13);
        list.add(-6);
        list.add(0);
        list.add(200);
        list.add(0);

        list.remove(-1);
    }

    @Test
    public void remove_fixedBugWithShiftToLeft() {
        List<Integer> list = new MyLinkedList<>();

        list.add(6);
        list.add(-15);
        list.add(0);

        list.remove(1);
        Assert.assertEquals(Integer.valueOf(6), list.get(0));
        Assert.assertEquals(Integer.valueOf(0), list.get(1));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void indexOf_withNullInTheList() {
        List<Integer> list = new MyLinkedList<>();

        list.add(6);
        list.add(null);
        list.add(0);

        Assert.assertEquals(0, list.indexOf(6));
        Assert.assertEquals(1, list.indexOf(null));
        Assert.assertEquals(2, list.indexOf(0));

        Assert.assertEquals(3, list.size());
    }

    @Test
    public void indexOf() {
        List<Integer> list = new MyLinkedList<>();

        list.add(6);
        list.add(13);
        list.add(0);

        Assert.assertEquals(0, list.indexOf(6));
        Assert.assertEquals(1, list.indexOf(13));
        Assert.assertEquals(2, list.indexOf(0));

        Assert.assertEquals(3, list.size());
    }

    @Test
    public void set() {
        List<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(-4);
        list.add(0);
        list.add(1);
        list.add(8);

        Assert.assertEquals(Integer.valueOf(-4), list.set(1, 500));
        Assert.assertFalse(list.contains(-4));
        Assert.assertEquals(Integer.valueOf(500), list.get(1));

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void lastIndexOf() {
        List<Integer> list = new MyLinkedList<>();

        list.add(13);
        list.add(-5);
        list.add(200);
        list.add(0);
        list.add(1);

        Assert.assertEquals(2, list.lastIndexOf(200));

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void lastIndexOf_indexOutOfBoundsException() {
        List<Integer> list = new MyLinkedList<>();

        list.add(13);
        list.add(-5);
        list.add(200);

        Assert.assertEquals(2, list.lastIndexOf(200));

        Assert.assertEquals(3, list.size());
    }

    @Test
    public void subList() {
        List<Integer> list = new MyLinkedList<>();

        list.add(3);
        list.add(18);
        list.add(-7);
        list.add(0);
        list.add(25);
        list.add(59);
        list.add(200);
        list.add(5);

        List<Integer> subList = list.subList(1, 5);

        Assert.assertEquals(Integer.valueOf(18), subList.get(0));
        Assert.assertEquals(Integer.valueOf(-7), subList.get(1));
        Assert.assertEquals(Integer.valueOf(0), subList.get(2));
        Assert.assertEquals(Integer.valueOf(25), subList.get(3));


        Assert.assertEquals(4, subList.size());

    }

    @Test
    public void remove_removedAllElementsOfTheListWithString() {
        List<String> list = new MyLinkedList<>();

        Assert.assertTrue(list.add("5"));
        Assert.assertTrue(list.add("0"));
        Assert.assertTrue(list.add("-10"));
        Assert.assertTrue(list.add("120"));
        Assert.assertTrue(list.add("27"));
        Assert.assertTrue(list.add("-60"));
        Assert.assertTrue(list.add("1"));
        Assert.assertTrue(list.add("0"));

        Assert.assertFalse(list.remove("-5"));
        Assert.assertFalse(list.remove("10000"));
        Assert.assertFalse(list.remove("10"));
        Assert.assertFalse(list.remove("-120"));
        Assert.assertEquals(8, list.size());

        Assert.assertTrue(list.remove("5"));
        Assert.assertEquals(7, list.size());
        Assert.assertEquals(7, list.size());
        Assert.assertFalse(list.contains("5"));
        Assert.assertEquals("0", list.get(0));

        Assert.assertTrue(list.remove("0"));
        Assert.assertEquals(6, list.size());
        Assert.assertTrue(list.contains("0"));
        Assert.assertEquals("-10", list.get(0));

        Assert.assertTrue(list.remove("-10"));
        Assert.assertEquals(5, list.size());
        Assert.assertFalse(list.contains("-10"));
        Assert.assertEquals("120", list.get(0));

        Assert.assertTrue(list.remove("120"));
        Assert.assertEquals(4, list.size());
        Assert.assertFalse(list.contains("120"));
        Assert.assertEquals("27", list.get(0));

        Assert.assertTrue(list.remove("27"));
        Assert.assertEquals(3, list.size());
        Assert.assertFalse(list.contains("27"));
        Assert.assertEquals("-60", list.get(0));

        Assert.assertTrue(list.remove("-60"));
        Assert.assertEquals(2, list.size());
        Assert.assertFalse(list.contains("-60"));
        Assert.assertEquals("1", list.get(0));

        Assert.assertTrue(list.remove("1"));
        Assert.assertEquals(1, list.size());
        Assert.assertFalse(list.contains("1"));
        Assert.assertEquals("0", list.get(0));

        Assert.assertTrue(list.remove("0"));
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains("0"));

        Assert.assertFalse(list.remove("-27"));
        Assert.assertFalse(list.remove("60"));
        Assert.assertFalse(list.remove("-1"));
        Assert.assertFalse(list.remove("10000000"));

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void test() {
        Object list = new Object();
        list = null;

    }
}
