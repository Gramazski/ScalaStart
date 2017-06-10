package com.gramazski.scalafirst.entity.impl

import com.gramazski.scalafirst.entity.Entity

class User(override val newId: Int) extends Entity(newId){
  private var _username :String = _
  private var _password :String = _

  def username: String = _username

  def username_= (newUsername: String): Unit = _username = newUsername

  def password: String = _password

  def password_= (password: String): Unit = _password = password
}
