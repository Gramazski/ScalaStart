package com.gramazski.stream

import scala.collection.mutable.ListBuffer
import scala.io.Source

class ScalaStreamTextDivider {
  def divideTextFromFile(filePath: String): Map[String, Int] = {
    val punctRegex = "\\p{Punct}"
    val spaceRegex = "\\s+"
    val fileText: List[String] = Source.fromFile(filePath).getLines().filter((s) => !s.isEmpty).toList
    val wordList: List[String] = fileText.flatMap((s) => s.replaceAll(punctRegex, " ").trim().toUpperCase().split(spaceRegex).toList)
    val wordMap: Map[String, Int] = wordList.groupBy(identity).mapValues(_.length)

    wordMap
  }
}
