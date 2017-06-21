package com.gramazski.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamTextDivider {
    public Map<String, Long> divideTextFromFile(String filePath){
        String punctRegex = "\\p{Punct}";
        String spaceRegex = "\\s+";
        Map<String, Long> wordMap = new HashMap<>();
        try {
            wordMap = Files.lines(Paths.get(filePath))
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.replaceAll(punctRegex, " ").trim().toUpperCase())
                    .map(line -> line.split(spaceRegex))
                    .flatMap(Arrays::stream)
                    .collect(groupingBy(identity(), counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordMap;
    }
}
