package org.dz.solution.task32;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task32Test {

    private static final String WORD_DELIMITER = " ";

    @Test
    public void test() throws IOException {
        int[] array = {1, 3, 4, 6, 9, 10, 12, 13, 14, 16, 19, 20};
        String sourceDataFile = "src/main/resources/org/dz/solution/task32/InputFile";
        String resultFile = "src/main/resources/org/dz/solution/task32/OutputFile";
        Files.deleteIfExists(Path.of("src/main/resources/org/dz/solution/task32/OutputFile"));

        findTheNumberOfNumbersInAFile(sourceDataFile);
        readingAFile(sourceDataFile);
        findTheMissingNumbers(array, resultFile);
    }

    private String[] findTheNumberOfNumbersInAFile(String sourceDataFile) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line = br.readLine();
            String[] words = line.split(WORD_DELIMITER);
            for (int i = 0; i < words.length; i++) {
                if (words.length > count) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
        return new String[count];
    }

    private int[] findTheMissingNumbers(int[] array, String resultFile) {
        int min = array[0];
        int max = array[array.length - 1];
        int[] newArray = new int[array.length];
        int index = 0;
        try (PrintWriter pw = new PrintWriter(resultFile)) {
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
                    pw.print(i + " ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
        return newArray;
    }

    private void readingAFile(String sourceDataFile) {
        findTheNumberOfNumbersInAFile(sourceDataFile);
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line = br.readLine();
            String[] elements = line.split(" ");
            int[] array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
    }

}