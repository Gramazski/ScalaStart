package com.gramazs.scalafirst.controller

import javax.servlet.annotation.WebServlet
import javax.servlet.http._

import com.gramazs.scalafirst.command.{CommandEnum, CommandManager, ICommand}


@WebServlet(Array("/controller"))
class FrontController extends HttpServlet{
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val command = defineCommand(req)
    command.handleRequest(req, resp)
  }

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val command = defineCommand(req)
    command.handleRequest(req, resp)
  }

  private def defineCommand(request: HttpServletRequest): ICommand = {
    CommandManager.getCommand(CommandEnum.withName(request.getParameter("command")))
  }
}
