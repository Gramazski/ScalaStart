package com.gramazs.scalafirst.command.impl

import java.io.IOException
import javax.servlet.http.{HttpServletRequest, HttpServletResponse, HttpSession}

import com.gramazs.scalafirst.command.ICommand
import com.gramazs.scalafirst.entity.impl.User
import com.gramazs.scalafirst.service.LoginService

class LoginCommand extends ICommand{
  override def handleRequest(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    try {
      var user = new User(-1)
      val username = request.getParameter("username")
      val password = request.getParameter("password")
      val loginService = new LoginService
      if (loginService.checkUser(username, password)) {
        user = loginService.user
        val session = request.getSession
        session.setAttribute("user", user)
      }
      response.setContentType("application/json")
      //Making json answer
      response.getWriter.write("{\"id\":\"" + user.id + "\",\"username\":\"" + user.username + "\", \"password\":\"\"}")
    } catch {
      case e: IOException =>
      //logging
    }
  }
}
