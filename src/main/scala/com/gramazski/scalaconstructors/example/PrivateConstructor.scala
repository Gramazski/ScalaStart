package com.gramazski.scalaconstructors.example

class PrivateConstructor private {
  def someMethod(): Unit = println("Do something")
  override def toString: String = "Private"
  println(toString)
}

object PrivateConstructor {
  private val privateConstructor: PrivateConstructor = new PrivateConstructor

  def getInstane: PrivateConstructor = {
    privateConstructor
  }
}
