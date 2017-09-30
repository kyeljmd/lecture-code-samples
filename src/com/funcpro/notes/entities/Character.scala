package com.funcpro.notes.entities



case class Character(val name:String, age:Int, var mostPlayedServer:String){

  def message = "Hello " + name;
  
  def switchServer(newServer:String) = mostPlayedServer = newServer;
  
  
}