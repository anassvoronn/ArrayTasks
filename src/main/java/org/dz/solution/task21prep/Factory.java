package org.dz.solution.task21prep;

public abstract class Factory {
    private final ColorGenerator colorGenerator;

    public Factory(final ColorGenerator colorGenerator) {
        System.out.println("Factory constructor start");
        this.colorGenerator = colorGenerator;
        System.out.println("Factory constructor finish");
    }

    protected abstract String getBrand();

    protected abstract int getPrice();

    protected abstract int getExtraPrice();

    public Car getCar() {
        String color = colorGenerator.getColor();
        return new Car(getBrand(), color, getPrice());
    }

    public Car getCar(String color) {
        return new Car(getBrand(), color, getPrice() + getExtraPrice());
    }
}
