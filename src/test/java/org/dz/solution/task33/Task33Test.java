package org.dz.solution.task33;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class Task33Test {
    private static final String BIG_FILE_WITH_TEXT = "src/test/resources/org/dz/solution/task33/BigFileWithText";
    private static final String SOURCE_DATA_FILE = "src/main/resources/org/dz/solution/task33/InputFile";
    private static final String RESULT_FILE = "src/main/resources/org/dz/solution/task33/OutputFile";
    private static final String[] SYMBOLS = new String[]{",", "-", "\\.", ";", "\\(", "\\)", ":", "\"", "«", "»", "„", "“"};
    public static final String WORD_DELIMITER = " ";

    @Test
    public void case1() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "кот, собака. кот( кот жираф ;котик- кот");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("жираф 1\nкот 4\nкотик 1\nсобака 1", actualResult);
    }

    @Test
    public void case2() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "вода „водоем водяной « водохранилище");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("вода 1\nводоем 1\nводохранилище 1\nводяной 1", actualResult);
    }

    @Test
    public void case3() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("", actualResult);
    }

    @Test
    public void case4() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), " ");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("", actualResult);
    }

    @Test
    public void case5() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), " 4");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("4 1", actualResult);
    }

    @Test
    public void case6() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "кот, собака.\n \n\nкот( кот \nжираф ;\nкотик- кот");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("жираф 1\nкот 4\nкотик 1\nсобака 1", actualResult);
    }

    @Test
    public void case7() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "\n\nвода „водоем\n водяной « \n\nводохранилище\n\n");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("вода 1\nводоем 1\nводохранилище 1\nводяной 1", actualResult);
    }

    @Test
    public void case8() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "кот, собака. Котик\n \n\nкот( Кот \nжираф ;\nКотик- кот");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("жираф 1\nкот 4\nкотик 2\nсобака 1", actualResult);
    }

    @Test
    public void case9() throws IOException {
        Files.writeString(Path.of(SOURCE_DATA_FILE), "\n\nвода „водоем\n водяной ВоДа« \n\nводохранилище\n\nВОДОХРАНИЛИЩЕ");
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
        assertEquals("вода 2\nводоем 1\nводохранилище 2\nводяной 1", actualResult);
    }
    
    @Test
    public void caseWithBigFile() throws IOException {
        String text = Files.readString(Path.of(BIG_FILE_WITH_TEXT));
        Files.writeString(Path.of(SOURCE_DATA_FILE), text);
        writeOutTheWordsAndTheNumberOfTheirRepetitions();
        String actualResult = Files.readString(Path.of(RESULT_FILE));
    }

    private void writeOutTheWordsAndTheNumberOfTheirRepetitions() {
        List<String> wordList = readWordsFromFile(SOURCE_DATA_FILE);
        Map<String, Integer> wordToCount = countWords(wordList);
        writeWordCountToFile(RESULT_FILE, wordToCount);
    }

    private String clearLine(String line) {
        for (String symbol : SYMBOLS) {
            line = line.replaceAll(symbol, WORD_DELIMITER);
        }
        return line;
    }

    private List<String> readWordsFromFile(String sourceDataFile) {
        List<String> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceDataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = clearLine(line);
                String[] lineWords = line.split(WORD_DELIMITER);
                for (String word : lineWords) {
                    if (Objects.equals(word, "")) {
                        continue;
                    } else if (Objects.equals(word, WORD_DELIMITER)) {
                        continue;
                    }
                    array.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("File reading failed");
            e.printStackTrace();
        }
        return array;
    }

    private Map<String, Integer> countWords(List<String> wordList) {
        Map<String, Integer> wordsToCounter = new HashMap<>();
        for (String word : wordList) {
            if (wordsToCounter.containsKey(word)) {
                int count = wordsToCounter.get(word);
                wordsToCounter.put(word, count + 1);
            } else {
                wordsToCounter.put(word, 1);
            }
        }
        return wordsToCounter;
    }

    public static void writeWordCountToFile(String resultFile, Map<String, Integer> arrayOfWords) {
        int count = 1;
        Set<Map.Entry<String, Integer>> entrySet = arrayOfWords.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        entryList.sort(Map.Entry.comparingByKey());
        try (PrintWriter writer = new PrintWriter(new FileWriter(resultFile))) {
            for (var entry : entryList) {
                if (count == arrayOfWords.size()) {
                    writer.print(entry.getKey() + " " + entry.getValue());
                    return;
                }
                writer.print(entry.getKey() + " " + entry.getValue() + "\n");
                count++;
            }
        } catch (IOException e) {
            System.out.println("Writing to the file failed");
            e.printStackTrace();
        }
    }
}