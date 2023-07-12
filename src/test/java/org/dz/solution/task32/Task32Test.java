package org.dz.solution.task32;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task32Test {

    private static final String WORD_DELIMITER = " ";

    @Test
    public void test() throws IOException {
        String sourceDataFile = "src/main/resources/org/dz/solution/task32/InputFile";
        String resultFile = "src/main/resources/org/dz/solution/task32/OutputFile";
        Files.deleteIfExists(Path.of(resultFile));
        //Посчитать количество чисел в файле. Сохранить в переменную countNumbers.
        //Записать числа в массив. Сохранить в переменную ссылающуюся на массив numbersFromFile.
        //Найти недостающие числа в numbersFromFile. записать в skippedNumbers недостающие числа.
        //записать skippedNumbers в файл.
        int countNumbers = findTheNumberOfNumbersInAFile(sourceDataFile);
        int[] numbersFromFile = writeNumbersToArray(countNumbers, sourceDataFile);
        int[] skippedNumbers = findTheMissingNumbers(numbersFromFile);
        writeArrayToFile(skippedNumbers, resultFile);
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
        readingAFile(sourceDataFile);
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
        int[] skippedNumbers = new int[numbersFromFile.length];
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
        return skippedNumbers;
    }

    private void writeArrayToFile(int[] skippedNumbers, String resultFile) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
            for (int i = 0; i < skippedNumbers.length; i++) {
                pw.print(skippedNumbers[i] + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Array creation failed", e);
        }
    }

}