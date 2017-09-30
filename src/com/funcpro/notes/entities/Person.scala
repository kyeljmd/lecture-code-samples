package com.funcpro.notes.entities

case class Person(val name: String) {
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}