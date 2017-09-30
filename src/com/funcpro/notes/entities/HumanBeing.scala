package com.funcpro.notes.entities

import com.funcpro.notes.traits.Movement


import com.funcpro.notes.traits.Talent

 class HumanBeing (var name: String, var gender: String, var age: Int) extends Movement {
  
  def greet: String = s"Hello from $name"
  
  def sayAge: String = "I am " + age + " years old"

  override def toString = s"User($name)"
  
  def walk:Unit =  println("I'm walking")
  
  def run:Unit = println("I'm running")
  
  def speak:String = greet;
}