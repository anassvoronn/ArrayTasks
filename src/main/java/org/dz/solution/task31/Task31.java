package org.dz.solution.task31;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task31 {
    public static void main(String[] args) {
        BufferedReader br = null;
        String filePath = "src/main/resources/org/dz/solution/task31/MyTestFile";

        String content;
        int line = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((content = br.readLine()) != null) {
                if (line % 2 == 0){
                    System.out.println(content);
                }
                line++;
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
}
