package com.funcpro.notes.entities

object NameHelper {
  
  def firstNameFormat(fName:String, mName:String, lName:String) = fName.toUpperCase+" "+mName.toUpperCase+", "+lName.toUpperCase;
  
  def lastNameFormat(fName:String, mName:String, lName:String) = lName.toUpperCase+", "+fName.toUpperCase +" "+ mName.toUpperCase;
  
}