package org.dz.solution.task31;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Task31Test {

    public static final String WORD_DELIMITER = " ";

    @Test
    public void writeReadStringMatrixFile() throws FileNotFoundException {
        String[][] expectedMatrix = {
                {"7", "Ок", "Коля", "13", "утка", "45"},
                {"Phone", "2,5", "string", "@", null, null},
                {"собака", null, null, null, null, null},
                {"%", "81", "Задание", "cat", "слово", null}
        };
        String filePath = "src/main/resources/org/dz/solution/task31/StringMatrix";
        //1. создать новый файл StringMatrix
        //2. записать expectedMatrix в StringMatrix файл разделяя каждое слово пробелом
        //3. методы не менять
        // можно использовать PrintWriter класс
        String filePathTwo = "src/main/resources/org/dz/solution/task31/EmptyStringMatrix";
        PrintWriter pw = new PrintWriter(filePathTwo);

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[i].length; j++) {
                pw.printf(filePathTwo);
            }
            pw.println();
        }
        String[][] actualMatrix = createMatrixFromFile(filePath);
        fillInTheMatrix(filePath, actualMatrix);
        Assert.assertEquals(expectedMatrix, actualMatrix);
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
