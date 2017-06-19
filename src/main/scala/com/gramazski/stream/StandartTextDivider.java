package com.gramazski.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StandartTextDivider {

    public Map<String, Integer> divideTextFromFile(String filePath){
        String syntaxRegex = "\\p{Punct}";
        Map<String, Integer> wordMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] wordsInLine = sCurrentLine.replaceAll(syntaxRegex, " ").toUpperCase().split(" ");
                addWordsToMap(wordsInLine, wordMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordMap;
    }

    private void addWordsToMap(String[] words, Map<String, Integer> worldMap){
        for (int i = 0; i < words.length; i++){
            Integer count = 1;

            if (worldMap.containsKey(words[i])){
                count += worldMap.get(words[i]);
            }

            worldMap.put(words[i], count);
        }
    }
}
