package com.gramazski.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CharRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/stream/test.txt");
        List<String> list = new ArrayList<String>();
        try {
            Files.lines(path).filter(s->!s.isEmpty()).forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> strings= list
                .stream()
                .collect(ArrayList::new, (l, str) ->
                                l.addAll(Arrays.asList(str.replaceAll("\\p{Punct}", "").trim().split("\\s+")))
                        , ArrayList::addAll);
        System.out.println(strings);
        Map<String, Integer> countStr = strings.stream().collect(HashMap::new, (map, str) ->
                        map.merge( str, 1, Integer::sum )
                , HashMap::putAll);
        System.out.println(countStr);
    }
}
