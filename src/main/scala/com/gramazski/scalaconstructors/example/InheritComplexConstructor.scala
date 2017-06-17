package com.gramazski.scalaconstructors.example

class InheritComplexConstructor(firstParam: String = "some", newParam: String) extends ComplexConstructor(firstParam){
  override def toString: String = super.toString + ";New param: " + newParam
}
