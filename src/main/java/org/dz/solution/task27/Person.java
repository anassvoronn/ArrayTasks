package org.dz.solution.task27;

public class Person {
    private final String fullName;
    private final int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Person() {
        fullName = "Вика";
        age = 15;
    }

    public void move() {
        System.out.println("Какой-то " + fullName + " идёт");
    }

    public void take() {
        System.out.println("Какой-то "+ this.fullName +" говорит");
    }
}
