package com.gramazs.scalafirst.command

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

trait ICommand {
  def handleRequest(request: HttpServletRequest, response: HttpServletResponse) : Unit
}
