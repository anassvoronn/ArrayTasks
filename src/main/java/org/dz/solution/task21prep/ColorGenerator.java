package org.dz.solution.task21prep;

import java.util.Random;

public class ColorGenerator {
    public String getColor() {
        String[] colors = new String[]{"Black", "Pink", "Yellow", "Blue", "White", "Red", "Green", "Purple", "Gray"};
        Random generator = new Random();
        int randomNumbers = generator.nextInt(colors.length);
        return colors[randomNumbers];
    }
}
