package org.dz.solution.task21prep;

public class LadaCarFactory extends Factory {
    public static final String BRAND = "Lada";
    public static final int DEFAULT_PRICE = 10_000;
    public static final int EXTRA_PRICE_FOR_COLOR = 1000;

    public LadaCarFactory(ColorGenerator colorGenerator) {
        super(colorGenerator);
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
