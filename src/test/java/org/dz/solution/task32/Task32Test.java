package org.dz.solution.task32;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Task32Test {
    int[] array;

    @Test
    public void test() throws IOException {
        String sourceDataFile = "src/main/resources/org/dz/solution/task32/InputFile";
        String resultFile = "src/main/resources/org/dz/solution/task32/OutputFile";
        Files.delete(Path.of("src/main/resources/org/dz/solution/task32/OutputFile"));

        PrintWriter pw = new PrintWriter(resultFile);
        readingAFile(sourceDataFile);
        pw.print(Arrays.toString(findTheMissingNumbers(array)));
        pw.close();
    }

    private int[] findTheMissingNumbers(int[] array) {
        int min = array[0];
        int max = array[array.length - 1];
        int[] newArray = new int[array.length];
        int index = 0;
        for (int i = min; i <= max; i++) {
            boolean foundNumber = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    foundNumber = true;
                    break;
                }
            }
            if (!foundNumber) {
                newArray[index] = i;
                index++;
                System.out.print(i + " ");
            }
        }
        return newArray;
    }

    private void readingAFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String[] elements = line.split(" ");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
    }

}