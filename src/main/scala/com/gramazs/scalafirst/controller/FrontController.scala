package com.gramazs.scalafirst.controller

import javax.servlet.annotation.WebServlet
import javax.servlet.http._

@WebServlet(Array("/controller"))
class FrontController extends HttpServlet{
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    defineCommand(req)
  }

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    defineCommand(req)
  }

  private def defineCommand(request: HttpServletRequest): Unit = {

  }
}
