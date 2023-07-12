package org.dz.solution.task32;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task32Test {

    private static final String WORD_DELIMITER = " ";
    private static final String SOURCE_DATA_FILE = "src/main/resources/org/dz/solution/task32/InputFile";
    private static final String RESULT_FILE = "src/main/resources/org/dz/solution/task32/OutputFile";

    @Before
    public void setUp() throws Exception {
        Files.deleteIfExists(Path.of(SOURCE_DATA_FILE));
        Files.deleteIfExists(Path.of(RESULT_FILE));
    }

    @Test
    public void inputFileEmpty() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "");
        calculateSkippedNumbers();
    }

    @Test
    public void case1() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 6 9 10 12 13 14 16 19 20");
        calculateSkippedNumbers();
    }

    @Test
    public void case2() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 12 13 14 16 19 20");
        calculateSkippedNumbers();
    }

    @Test
    public void case3() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        calculateSkippedNumbers();
    }

    private void calculateSkippedNumbers() {
        int countNumbers = findTheNumberOfNumbersInAFile(SOURCE_DATA_FILE);
        int[] numbersFromFile = writeNumbersToArray(countNumbers, SOURCE_DATA_FILE);
        int[] skippedNumbers = findTheMissingNumbers(numbersFromFile);
        writeArrayToFile(skippedNumbers, RESULT_FILE);
    }

    private int findTheNumberOfNumbersInAFile(String sourceDataFile) {
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
        return count;
    }

    private int[] writeNumbersToArray(int countNumbers, String sourceDataFile) {
        int[] array = new int[countNumbers];
        array = readingAFile(sourceDataFile);
        return array;
    }

    private int[] readingAFile(String sourceDataFile) {
        int[] array;
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line = br.readLine();
            String[] elements = line.split(" ");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
                System.out.print(array[i] + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
        return array;
    }

    private int[] findTheMissingNumbers(int[] numbersFromFile) {
        int[] skippedNumbers = new int[20];
        int index = 0;
        int min = numbersFromFile[0];
        int max = numbersFromFile[numbersFromFile.length - 1];
        for (int i = min; i <= max; i++) {
            boolean foundNumber = false;
            for (int j = 0; j < numbersFromFile.length; j++) {
                if (numbersFromFile[j] == i) {
                    foundNumber = true;
                    break;
                }
            }
            if (!foundNumber) {
                skippedNumbers[index] = i;
                index++;
                System.out.print(skippedNumbers[index] + " ");
            }
        }
        int[] newArray = new int[index];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = skippedNumbers[i];
        }
        return newArray;
    }

    private void writeArrayToFile(int[] skippedNumbers, String resultFile) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
            for (int i = 0; i < skippedNumbers.length; i++) {
                pw.println(skippedNumbers[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
    }

}