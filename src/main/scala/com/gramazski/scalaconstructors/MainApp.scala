package com.gramazski.scalaconstructors

import com.gramazski.scalaconstructors.example.{ComplexConstructor, PrivateConstructor}


object MainApp extends App{
  println("Param access for val, var, default and modifier private: ")
  var complexConstructor: ComplexConstructor = new ComplexConstructor()
  println(complexConstructor)
  println(complexConstructor.firstParam)
  complexConstructor.firstParam = "Some new value"
  println(complexConstructor)
  println("/*------------------------------------------------------------------------------*/")

  println("Constructors overloading: ")
  complexConstructor = new ComplexConstructor("Another first param")
  println(complexConstructor)
  complexConstructor = new ComplexConstructor("Another another first param", "Second param")
  println(complexConstructor)
  complexConstructor = new ComplexConstructor("Another another first param", "Second param", 20)
  println(complexConstructor)
  println("/*------------------------------------------------------------------------------*/")

  println("Private constructors, singleton pattern: ")
  val singletonPrivateConstructor = PrivateConstructor.getInstane
  singletonPrivateConstructor.someMethod()
}
