package com.gramazs.scalafirst.command.impl

import javax.servlet.http.{HttpServletRequest, HttpServletResponse, HttpSession}

import com.gramazs.scalafirst.command.ICommand

class LogoutCommand extends ICommand{
  override def handleRequest(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val session: HttpSession = request.getSession
    session.invalidate()
  }
}
