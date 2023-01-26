package org.dz.solution.task26;

import java.util.Formatter;

public class Phone {
    private final String number;
    private final String model;
    private final int weight;

    public Phone(final String number, final String model, final int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(final String number, final String model) {
        this(number, model, 209);
    }

    public Phone() {
        number = "+37529xxxxxxxx";
        model = "N/A";
        weight = 100;
    }

    public String getModel() {
        return model;
    }

    public void receiveCall(final String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(final String number, String name) {
        System.out.println("Звонит " + name + " " + number);
    }

    public String getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println("Отправил сообщение на номер " + number);
        }
        System.out.println();
    }
}
