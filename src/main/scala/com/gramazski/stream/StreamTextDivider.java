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
        String syntaxRegex = "\\p{Punct}";
        Map<String, Long> wordMap = new HashMap<>();
        try {
            wordMap = Files.lines(Paths.get(filePath))
                    .map(line -> line.replaceAll(syntaxRegex, " ").toUpperCase())
                    .map(line -> line.split("\\s+"))
                    .flatMap(Arrays::stream)
                    .collect(groupingBy(identity(), counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordMap;
    }
}
