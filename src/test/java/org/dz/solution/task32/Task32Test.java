package org.dz.solution.task32;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Task32Test {

    public static final String WORD_DELIMITER = " ";

    @Test
    public void test() throws IOException {
        String[][] expectedMatrix = {
                {"1", null, "3", "4", null},
                {"6", null, null, "9", "10"},
                {null, "12", "13", "14", null},
                {"16", null, null, "19", "20"}
        };
        String filePath = "src/main/resources/org/dz/solution/task32/InputFile";

        String filePathTwo = "src/main/resources/org/dz/solution/task32/OutputFile";
        PrintWriter pw = new PrintWriter(filePathTwo);
        for (String[] matrix : expectedMatrix) {
            for (String s : matrix) {
                if (s == null) {
                    pw.print(s);
                }
            }
            pw.println();
        }
        pw.close();

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