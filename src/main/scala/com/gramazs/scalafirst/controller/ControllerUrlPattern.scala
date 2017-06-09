package com.gramazs.scalafirst.controller

object ControllerUrlPattern extends ControllerUrlPattern

sealed trait ControllerUrlPattern {
  final val URL: Array[String] = Array("/controller")
}
