package org.dz.solution.task32;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Task32Test {

    public static final String WORD_DELIMITER = " ";

    @Test
    public void test() throws IOException {
        int[] array = {1, 3, 4, 6, 9, 10, 12, 13, 14, 16, 19, 20};
        String filePath = "src/main/resources/org/dz/solution/task32/InputFile";

        String filePathTwo = "src/main/resources/org/dz/solution/task32/OutputFile";
        int min = array[0];
        int max = array[array.length - 1];

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
            }
        }
    }

    private String[][] createMatrixFromFile(String filePath) {
        int numberOfLines = 0;
        int numberOfColumns = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numberOfLines++;
                String[] words = line.split(WORD_DELIMITER);
                if (words.length > numberOfColumns) {
                    numberOfColumns = words.length;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Matrix creation failed", e);
        }
        return new String[numberOfLines][numberOfColumns];
    }

    private void fillInTheMatrix(String filePath, String[][] matrix) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < matrix.length; i++) {
                String line = br.readLine();
                String[] words = line.split(WORD_DELIMITER);
                for (int j = 0; j < words.length; j++) {
                    matrix[i][j] = words[j];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Filling in the matrix failed", e);
        }
    }
}