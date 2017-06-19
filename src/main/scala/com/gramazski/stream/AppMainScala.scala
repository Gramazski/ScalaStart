package com.gramazski.stream

object AppMainScala extends App{
  val scalaStreamTextDivider = new ScalaStreamTextDivider
  val map: Map[String, Int] = scalaStreamTextDivider.divideTextFromFile("src/main/resources/stream/test.txt")
  scalaStreamTextDivider.divideTextFromFile("src/main/resources/stream/test.txt").foreach((e: (String, Int)) => println(e._1 + "=" + e._2))
}
