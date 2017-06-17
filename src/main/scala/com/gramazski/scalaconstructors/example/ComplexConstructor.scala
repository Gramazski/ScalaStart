package com.gramazski.scalaconstructors.example

class ComplexConstructor(var firstParam: String, private var secondParam: String, defaultParam: Int = 100) {
  println("constructor start.")

  def this(firstParam: String){this(firstParam, "default")}
  def this(){this("firstParam")}

  override def toString: String = "First param: " + firstParam + ";Second param: " + secondParam + ";Default param: " + defaultParam

  println("constructor end.")
}
