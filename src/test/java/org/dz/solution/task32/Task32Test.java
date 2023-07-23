package org.dz.solution.task32;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task32Test {

    private static final String SOURCE_DATA_FILE = "src/main/resources/org/dz/solution/task32/InputFile";
    private static final String RESULT_FILE = "src/main/resources/org/dz/solution/task32/OutputFile";
    private static final String[] BAD_SYMBOLS = new String[]{",", "-", "\\."};

    @Before
    public void setUp() throws Exception {
        Files.deleteIfExists(Path.of(SOURCE_DATA_FILE));
        Files.deleteIfExists(Path.of(RESULT_FILE));
    }

    @Test
    public void inputFileEmpty() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20", actualResult);
    }

    @Test
    public void case1() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 6 9 10 12 13 14 16 19 20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n5\n7\n8\n11\n15\n17\n18", actualResult);
    }

    @Test
    public void case2() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 12 13 14 16 19 20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n5\n6\n7\n8\n9\n10\n11\n15\n17\n18", actualResult);
    }

    @Test
    public void case3() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("", actualResult);
    }

    @Test
    public void case4() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 6 13 14");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n5\n7\n8\n9\n10\n11\n12\n15\n16\n17\n18\n19\n20", actualResult);
    }

    @Test
    public void case5() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20", actualResult);
    }

    @Test
    public void case6() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19", actualResult);
    }

    @Test
    public void case7() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "16 20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n17\n18\n19", actualResult);
    }

    @Test
    public void case8() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 3 4 12\n13 14 16 19\n20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n5\n6\n7\n8\n9\n10\n11\n15\n17\n18", actualResult);
    }

    @Test
    public void case9() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1 2 3 4\n5 6 7 8 9\n10 11 12 13 14\n15\n16 17 18\n19 20");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("", actualResult);
    }

    @Test
    public void case10() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1\n3\n4\n6\n13\n14");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("2\n5\n7\n8\n9\n10\n11\n12\n15\n16\n17\n18\n19\n20", actualResult);
    }

    @Test
    public void case11() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "1,. 2 3 4\n5 6- 7 8 9\n10 11 12 13. 14\n15\n16 ,17, 18\n19 20,");
        calculateSkippedNumbers();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("", actualResult);
    }

    private void calculateSkippedNumbers() {
        List<Integer> numbersFromFile = writeNumbersToArray(SOURCE_DATA_FILE);
        List<Integer> skippedNumbers = findTheMissingNumbers(numbersFromFile);
        writeArrayToFile(skippedNumbers, RESULT_FILE);
    }

    private List<Integer> writeNumbersToArray(String sourceDataFile) {
        List<Integer> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int j = 0; j < BAD_SYMBOLS.length; j++) {
                    line = line.replaceAll(BAD_SYMBOLS[j], "");
                }
                String[] words = line.split(" ");
                for (String element : words) {
                    array.add(Integer.parseInt(element));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Array not cleared", e);
        }
        return array;
    }

    private List<Integer> findTheMissingNumbers(List<Integer> numbersFromFile) {
        List<Integer> skippedNumbers = new ArrayList<>();
        if (numbersFromFile.size() == 0) {
            for (int i = 1; i <= 20; i++) {
                skippedNumbers.add(i);
            }
            return skippedNumbers;
        }
        int min = 1;
        for (int i = min; i <= 20; i++) {
            boolean foundNumber = false;
            for (int j = 0; j < numbersFromFile.size(); j++) {
                if (numbersFromFile.get(j) == i) {
                    foundNumber = true;
                    break;
                }
            }
            if (!foundNumber) {
                skippedNumbers.add(i);
            }
        }
        return skippedNumbers;
    }

    private void writeArrayToFile(List<Integer> skippedNumbers, String resultFile) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
            for (int i = 0; i < skippedNumbers.size(); i++) {
                if (i == skippedNumbers.size() - 1) {
                    pw.print(skippedNumbers.get(i));
                    return;
                }
                pw.print(skippedNumbers.get(i) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Array write failed", e);
        }
    }

}