package org.dz.solution.task27;

import org.junit.Test;

public class Task27Test {

    @Test
    public void test1() {
        Person person1 = new Person("Лена", 25);
        Person person2 = new Person("Вика", 15);

        Person person3 = new Person();

        person3.move();
        person3.take();

        person1.move();
        person2.take();
    }
}