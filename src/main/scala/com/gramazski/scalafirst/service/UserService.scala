package com.gramazski.scalafirst.service

import com.gramazski.scalafirst.entity.impl.User

object UserService {
  def findUserByUsername(username: String): User = {
    val user = new User(0)
    user.username_=(username)
    user.password_=("")
    if ("user" == username) user.id_=(1)
    if ("admin" == username) user.id_=(2)
    user
  }
}
