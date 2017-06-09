package com.gramazs.scalafirst.service

import com.gramazs.scalafirst.entity.impl.User

class LoginService {
  private var _user :User = _

  def checkUser(username: String, password: String): Boolean = {
    val userService = new UserService
    if (("user".equals(username) && "password".equals(password)) || ("admin".equals(username) && "adminpas".equals(password))) {
      _user = userService.findUserByUsername(username)
      return true
    }
    false
  }

  def user: User = _user
}
