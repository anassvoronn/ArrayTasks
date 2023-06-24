package org.dz.solution.task32;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Task32Test {

    @Test
    public void test() throws IOException {
        int[] array = {1, 3, 4, 6, 9, 10, 12, 13, 14, 16, 19, 20};
        String filePath = "src/main/resources/org/dz/solution/task32/InputFile";
        String filePathTwo = "src/main/resources/org/dz/solution/task32/OutputFile";
        PrintWriter pw = new PrintWriter(filePathTwo);
        int min = array[0];
        int max = array[array.length - 1];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String[] elements = line.split(" ");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
            br.close();
            for (int i = min; i <= max; i++) {
                boolean foundNumber = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == i) {
                        foundNumber = true;
                        break;
                    }
                }
                if (!foundNumber) {
                    System.out.print(i + " ");
                    pw.print(i + " ");
                }
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException("Matrix creation failed", e);
        }
    }

}