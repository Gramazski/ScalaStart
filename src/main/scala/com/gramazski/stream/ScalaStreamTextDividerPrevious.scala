package com.gramazski.stream

import scala.io.Source

class ScalaStreamTextDividerPrevious {
  def divideTextFromFile(filePath: String): Map[String, Int] = {
    val punctRegex = "\\p{Punct}"
    val spaceRegex = "\\s+"
    val wordMap: Map[String, Int] = Source.fromFile(filePath).mkString
      .replaceAll(punctRegex, " ").toUpperCase().split(spaceRegex).groupBy(identity).mapValues(_.length)

    wordMap
  }

}
