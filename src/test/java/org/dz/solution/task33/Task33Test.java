package org.dz.solution.task33;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class Task33Test {
    private static final String SOURCE_DATA_FILE = "src/main/resources/org/dz/solution/task33/InputFile";
    private static final String RESULT_FILE = "src/main/resources/org/dz/solution/task33/OutputFile";
    private static final String[] SYMBOLS = new String[]{",", "-", "\\.", ";", "(", ")", ":", "\"", "«", "»", "„", "“"};
    public static final String WORD_DELIMITER = " ";

    @Test
    public void case1() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "кот, собака. кот( кот жираф ;котик кот");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("кот 4\n", actualResult);
    }

    @Test
    public void case2() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "вода „водоем водяной « водохранилище");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("водяной 1\n", actualResult);
    }

    private void writeOutTheWordsAndTheNumberOfTheirRepetitions() {
        List<String> wordList = readTextFromFile(SOURCE_DATA_FILE);
        repCounting(wordList);
        writeWordCountToFile(RESULT_FILE);
    }

    private List<String> readTextFromFile(String sourceDataFile) {
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

    private void repCounting(List<String> wordList) {
        Map<String, Integer> arrayOfWords = new HashMap<>();
        for (String word : wordList) {
            if (arrayOfWords.containsKey(word)) {
                int count = arrayOfWords.get(word);
                arrayOfWords.put(word, count + 1);
            } else {
                arrayOfWords.put(word, 1);
            }
        }
    }

    public static void writeWordCountToFile(String resultFile) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (PrintWriter writer = new PrintWriter(new FileWriter(resultFile))) {
            for (var entry : wordCount.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Writing to the file failed");
            e.printStackTrace();
        }
    }
}