package org.dz.solution.task21prep;

public class MercedesCarFactory extends Factory {

    public static final String BRAND = "Mercedes";
    public static final int DEFAULT_PRICE = 10_000;
    public static final int EXTRA_PRICE_FOR_COLOR = 1000;

    public MercedesCarFactory(final ColorGenerator colorGenerator) {
        super(colorGenerator);
        System.out.println("Mercedes constructor start");
        System.out.println("Mercedes constructor finish");
    }

    @Override
    protected String getBrand() {
        return BRAND;
    }

    @Override
    protected int getPrice() {
        return DEFAULT_PRICE;
    }

    @Override
    protected int getExtraPrice() {
        return EXTRA_PRICE_FOR_COLOR;
    }
}
