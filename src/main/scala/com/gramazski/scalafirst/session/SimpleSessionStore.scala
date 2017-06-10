package com.gramazski.scalafirst.session

object SimpleSessionStore extends SessionStore{
  private val storage = scala.collection.mutable.Map[String, UserSession]()

  def get(sid: String): Unit = storage get sid

  def put(data: UserSession): String = {
    val sid = generateSid
    SimpleSessionStore.synchronized {
      storage += (sid -> data)
    }
    sid
  }

  def remove(sid: String): Unit = {
    SimpleSessionStore.synchronized {
      if (storage.contains(sid)){
        storage -= sid
      }
    }
  }

  def dump: Map[String, UserSession] = storage.toMap

  protected def generateSid: String = scala.util.Random.alphanumeric.take(256).mkString
}

trait SessionStore{
  def get(sid: String)
  def put(data: UserSession): String
  def remove(sid: String)
}

case class UserSession(username: String)
