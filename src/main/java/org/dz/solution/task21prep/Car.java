package org.dz.solution.task21prep;

public class Car {
    private static int SERIAL_NUMBER;
    private final String brand;
    private final String color;
    private final int serialNumber;
    private final int price;

    public Car(final String brand, final String color, final int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.serialNumber = ++SERIAL_NUMBER;
    }

    public Car(final String brand, final int price) {
        this.brand = brand;
        this.color = "White";
        this.price = price;
        this.serialNumber = ++SERIAL_NUMBER;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "b='" + brand + '\'' +
                ", c='" + color + '\'' +
                ", s=" + serialNumber +
                ", p=" + price +
                '}';
    }
}
