package org.dz.solution.task33;

import org.junit.Test;

import java.io.*;
import java.util.*;


public class Task33Test {
    private static final String SOURCE_DATA_FILE = "src/main/resources/org/dz/solution/task33/MainFile";
    private static final String RESULT_FILE = "src/main/resources/org/dz/solution/task33/OutputFile";
    private static final String[] SYMBOLS = new String[]{",", "-", "\\.", ";", "(", ")", ":", "\"", "«", "»", "„", "“"};
    public static final String WORD_DELIMITER = " ";

    @Test
    public void test() {
        int a = 10;
        System.out.println(a++);
        System.out.println(a);
    }

    private void calculateSkippedNumbers() {
        List<String> textFromFile = writeNumbersToArray(SOURCE_DATA_FILE);
    }

    private List<String> writeNumbersToArray(String sourceDataFile) {
        List<String> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String symbol : SYMBOLS) {
                    line = line.replaceAll(symbol, WORD_DELIMITER);
                }
                String[] lineWords = line.split(WORD_DELIMITER);
                Collections.addAll(array, lineWords);
            }
        } catch (IOException e) {
            System.out.println("File reading failed");
            e.printStackTrace();
        }
        return array;
    }

    private void wordCount() {
        Map<String, Integer> wordCount = new HashMap<>();
        List<String> array = new ArrayList<>();
        for (String word : array) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
    }

    public static void writeWordCountToFile(String resultFile) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (PrintWriter writer = new PrintWriter(new FileWriter(resultFile))){
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        }catch (IOException e){
            System.out.println("Data not written to file");
            e.printStackTrace();
        }
    }
}