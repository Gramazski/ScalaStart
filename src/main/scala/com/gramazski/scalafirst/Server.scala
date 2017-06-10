package com.gramazski.scalafirst

import com.gramazski.scalafirst.plan.MainPlan
import unfiltered.jetty._

object Server {
  def main(args: Array[String]): Unit = {
    unfiltered.jetty.Http.apply(8080, "127.0.0.1").resources(getClass.getResource("/app/")).plan(MainPlan).run()
  }
}
