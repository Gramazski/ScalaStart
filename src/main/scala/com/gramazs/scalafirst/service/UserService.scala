package com.gramazs.scalafirst.service

import com.gramazs.scalafirst.entity.impl.User

class UserService {
  def findUserByUsername(username: String): User = {
    val user = new User(0)
    user.username_=(username)
    user.password_=("")
    if ("user" == username) user.id_=(1)
    if ("admin" == username) user.id_=(2)
    user
  }
}
