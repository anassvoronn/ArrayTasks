package org.dz.solution.task31;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task31Test {

    public static final String WORD_DELIMITER = " ";

    @Test
    public void readStringMatrixFile() {
        String filePath = "src/main/resources/org/dz/solution/task31/StringMatrix";
        String[][] matrix = createMatrixFromFile(filePath);
        fillInTheMatrix(filePath, matrix);
        Assert.assertEquals(new String[][]{
                {"7", "Ок", "Коля", "13", "утка", "45"},
                {"Phone", "2,5", "string", "@", null, null},
                {"собака", null, null, null, null, null},
                {"%", "81", "Задание", "cat", "слово", null}
        }, matrix);
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
