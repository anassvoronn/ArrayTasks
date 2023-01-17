package org.dz.solution.task21prep;

public class BMWCarFactory {
    public static final String BRAND = "BMW";
    public static final int DEFAULT_PRICE = 20_000;
    public static final int EXTRA_PRICE_FOR_COLOR = 1850;
    private final ColorGenerator colorGenerator;


    public BMWCarFactory(ColorGenerator colorGenerator) {
        this.colorGenerator = colorGenerator;
    }

    public Car getCar() {
        String color = colorGenerator.getColor();
        return new Car(BRAND, color, DEFAULT_PRICE);
    }

    public Car getCar(String color) {
        return new Car(BRAND, color, DEFAULT_PRICE + EXTRA_PRICE_FOR_COLOR);
    }
}
