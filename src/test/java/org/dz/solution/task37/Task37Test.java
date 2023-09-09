package org.dz.solution.task37;

import org.junit.Assert;
import org.junit.Test;

public class Task37Test {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        boolean hasCycle = hasCycle(head);
        Assert.assertFalse(hasCycle);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        boolean hasCycle = hasCycle(head);
        Assert.assertTrue(hasCycle);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        boolean hasCycle = hasCycle(head);
        Assert.assertTrue(hasCycle);
    }

    @Test
    public void test4() {
        ListNode head = null;
        Assert.assertFalse(hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }
}