package com.gramazski.scalafirst.plan
import java.io.OutputStream

import com.gramazski.scalafirst.service.{LoginService, UserService}
import com.gramazski.scalafirst.session.{SimpleSessionStore, UserSession}
import unfiltered.filter.Plan.Intent
import unfiltered.request._
import unfiltered.response.{BadRequest, JsonContent, Ok, Redirect, ResponseStreamer, ResponseString, SetCookies}
import unfiltered.Cookie

object MainPlan extends unfiltered.filter.Plan{
  private val SESSION_KEY: String = "SESSION_KEY"
  override def intent: Intent = {
    case req@POST(Path("/login")) =>{
      req match {
        case Params(params) => {
          if (LoginService.checkUser(params("username").mkString, params("password").mkString)) {
            val user = UserService.findUserByUsername(params("username").mkString)
            val sid: String = SimpleSessionStore.put(UserSession(user.username))
            Ok ~> SetCookies(Cookie(SESSION_KEY, sid)) ~> JsonContent ~> ResponseString("{\"id\":\"" + user.id + "\",\"username\":\"" + user.username + "\", \"password\":\"\"}")
          }
          else {
            BadRequest ~> JsonContent ~> ResponseString("Incorrect!")
          }
        }
      }
    }
    case req@POST(Path("/logout")) =>{
      req match {
        case Cookies(cookies) => {
          SimpleSessionStore.remove(cookies.getOrElse(SESSION_KEY, default = "").toString)
          SetCookies(Cookie(SESSION_KEY, "")) ~> Redirect("/#/")
        }
      }
    }
    //case GET(Path(Seg("ui" :: path))) => responseStreamer(path.mkString("/"))
    case GET(Path("/")) => responseStreamer("app/index.html")
    //case _ => responseStreamer("app/index.html")

  }

  private def responseStreamer(path: String) = new ResponseStreamer {
    def stream(os: OutputStream){
      val is = getClass.getClassLoader.getResourceAsStream(path)
      try {
        val buf = new Array[Byte](1024)
        Iterator.continually(is.read(buf))
          .takeWhile(_ != -1)
          .foreach(os.write(buf, 0, _))
      } finally {
        is.close()
      }
    }
  }
}
