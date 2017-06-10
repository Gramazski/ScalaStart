package com.gramazski.scalafirst.entity

abstract class Entity(val newId: Int) {
  private var _id: Int = newId

  def id: Int = _id
  def id_= (newId: Int): Unit = _id = newId

  override def equals(obj: scala.Any): Boolean = {
    if (this == obj) return true
    if (obj == null || (getClass ne obj.getClass)) return false

    val entity = obj.asInstanceOf[Entity]

    id == entity.id
  }

  override def hashCode(): Int = id
}
