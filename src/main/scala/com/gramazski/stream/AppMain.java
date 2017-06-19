package com.gramazski.stream;

public class AppMain {
    public static void main(String[] args){
        StandartTextDivider standartTextDivider = new StandartTextDivider();
        StreamTextDivider streamTextDivider = new StreamTextDivider();

        standartTextDivider.divideTextFromFile("src/main/resources/stream/test.txt")
                .forEach((k,v)->System.out.println(k + "=" + v));
        streamTextDivider.divideTextFromFile("src/main/resources/stream/test.txt")
                .forEach((k,v)->System.out.println(k + "=" + v));
    }
}
