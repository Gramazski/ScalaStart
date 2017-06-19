package com.gramazski.stream

import java.io.IOException
import java.nio.file.{Files, Paths}
import java.util
import scala.io.Source

class ScalaStreamTextDivider {
  def divideTextFromFile(filePath: String): Map[String, Int] = {
    val syntaxRegex = "\\p{Punct}"
    val wordMap: Map[String, Int] = Source.fromFile(filePath).mkString.replaceAll(syntaxRegex, " ").toUpperCase().split("\\s+").groupBy(identity).mapValues(_.length)

    wordMap
  }
}
