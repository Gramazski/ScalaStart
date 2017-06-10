package com.gramazski.scalafirst.service

import com.gramazski.scalafirst.entity.impl.User

object LoginService {
  def checkUser(username: String, password: String): Boolean = {
    ("user".equals(username) && "password".equals(password)) || ("admin".equals(username) && "adminpas".equals(password))
  }
}
