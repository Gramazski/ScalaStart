package com.gramazski.stream

object AppMainScala extends App{
  val scalaStreamTextDivider = new ScalaStreamTextDivider
  val scalaStreamTextDividerPrevious = new ScalaStreamTextDividerPrevious
  scalaStreamTextDivider.divideTextFromFile("src/main/resources/stream/test.txt").foreach((e: (String, Int)) => println(e._1 + "=" + e._2))
  scalaStreamTextDividerPrevious.divideTextFromFile("src/main/resources/stream/test.txt").foreach((e: (String, Int)) => println(e._1 + "=" + e._2))
}
