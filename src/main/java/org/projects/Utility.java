package org.projects;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@UtilityClass
public class Utility {
    public String[] divideTextIntoWords(String text) {
        return text.replaceAll("[^a-zA-Z0-9]", " ").split("\\s+");
    }

    @SneakyThrows
    public String readTextFromFilePath(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
