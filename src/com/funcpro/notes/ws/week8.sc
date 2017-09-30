package com.funcpro.notes.ws

import com.funcpro.notes.entities.Car;
import com.funcpro.notes.entities.Character;
import com.funcpro.notes.entities.HumanBeing;

import com.funcpro.notes.traits.Movement

import com.funcpro.notes.entities.NameHelper;
import scala.collection.mutable.ListBuffer

import com.funcpro.notes.entities.Course;

object week8 {
  //CLASSES AND OBJECTS

  val toyota = new Car("Toyota", false)           //> toyota  : com.funcpro.notes.entities.Car = Car(Toyota,false)

  println(s"My ${toyota.make} is now reserved? ${toyota.reserved}");
                                                  //> My Toyota is now reserved? false

  val toyotaTwo = new Car("Toyota", false)        //> toyotaTwo  : com.funcpro.notes.entities.Car = Car(Toyota,false)

  toyotaTwo.equals(toyota)                        //> res0: Boolean = true

  val c1 = new Character("Lodi", 23, "SEA Server");
                                                  //> c1  : com.funcpro.notes.entities.Character = Character(Lodi,23,SEA Server)
  val c2 = new Character("John Lloyd", 22, "AS Server");
                                                  //> c2  : com.funcpro.notes.entities.Character = Character(John Lloyd,22,AS Serv
                                                  //| er)

  println(c1.message)                             //> Hello Lodi

  c1.equals(c2);                                  //> res1: Boolean = false
  //c1.age -> this isn't allowed since age is private

  val hooman: Movement = new HumanBeing("John Lloyd", "male", 22);
                                                  //> hooman  : com.funcpro.notes.traits.Movement = User(John Lloyd)
  hooman.walk                                     //> I'm walking
  hooman.run                                      //> I'm running

  //object
  val firstNameFormat = NameHelper.firstNameFormat("kyel", "john", "david");
                                                  //> firstNameFormat  : String = KYEL JOHN, DAVID

  val lastNameFormat = NameHelper.lastNameFormat("kyel", "john", "david");
                                                  //> lastNameFormat  : String = DAVID, KYEL JOHN

  //collections

  //immutable collections
  val numbers = List(32, 95, 24, 21, 17)          //> numbers  : List[Int] = List(32, 95, 24, 21, 17)

  val colors = List("red", "green", "blue")       //> colors  : List[String] = List(red, green, blue)

  println(s"I have ${colors.size} colors: $colors")
                                                  //> I have 3 colors: List(red, green, blue)

  val course1 = new Course("Intro to programming", "ITC101")
                                                  //> course1  : com.funcpro.notes.entities.Course = Course(Intro to programming,
                                                  //| ITC101)

  val course2 = new Course("Intro to Database Programming", "ITC201")
                                                  //> course2  : com.funcpro.notes.entities.Course = Course(Intro to Database Pro
                                                  //| gramming,ITC201)

  val course3 = new Course("Introduction to functional Programming", "SELECT01")
                                                  //> course3  : com.funcpro.notes.entities.Course = Course(Introduction to funct
                                                  //| ional Programming,SELECT01)

  val courses = List(course1, course2, course3)   //> courses  : List[com.funcpro.notes.entities.Course] = List(Course(Intro to p
                                                  //| rogramming,ITC101), Course(Intro to Database Programming,ITC201), Course(In
                                                  //| troduction to functional Programming,SELECT01))
  //If you want a modifiable list, use  List Buffer

  val countryBuffer = ListBuffer[String]();       //> countryBuffer  : scala.collection.mutable.ListBuffer[String] = ListBuffer()
                                                  //| 
  countryBuffer.append("Philippines")
  countryBuffer.append("Mexico")
  countryBuffer.append("United States of America")

  val countryList = countryBuffer.toList          //> countryList  : List[String] = List(Philippines, Mexico, United States of Am
                                                  //| erica)
  countryList(0)                                  //> res2: String = Philippines
  countryList(1)                                  //> res3: String = Mexico
  countryList(2)                                  //> res4: String = United States of America

  for (i <- 0 until countryList.size) {
    println(countryList(i))                       //> Philippines
                                                  //| Mexico
                                                  //| United States of America
  }

  val primes = List(2, 3, 5, 7, 11, 13)           //> primes  : List[Int] = List(2, 3, 5, 7, 11, 13)

  var i = primes                                  //> i  : List[Int] = List(2, 3, 5, 7, 11, 13)

  while (i != Nil) { print(i.head + ", "); i = i.tail }
                                                  //> 2, 3, 5, 7, 11, 13, 
  
  //Converts our List of String into a List of Tuple that contains the name of the country, and the number of Character it has
  countryList.map(( c:String) => (c,c.length()) ) //> res5: List[(String, Int)] = List((Philippines,11), (Mexico,6), (United Stat
                                                  //| es of America,24))
  
  
  val combi = List(1, 2) ++ Set(3, 4, 3)          //> combi  : List[Int] = List(1, 2, 3, 4)
    
  val isEquals = List(1, 2) == List(1, 2)         //> isEquals  : Boolean = true
  
  val newCourseList = List(course1,course2, course3,course1).distinct
                                                  //> newCourseList  : List[com.funcpro.notes.entities.Course] = List(Course(Intr
                                                  //| o to programming,ITC101), Course(Intro to Database Programming,ITC201), Cou
                                                  //| rse(Introduction to functional Programming,SELECT01))
                                                  
  newCourseList.length                            //> res6: Int = 3
  
  val getTheLast2Elem = List('a', 'b', 'c', 'd') drop 2
                                                  //> getTheLast2Elem  : List[Char] = List(c, d)
                                          
 	val adultList =  List(23, 8, 14, 21) filter (_ > 18)
                                                  //> adultList  : List[Int] = List(23, 21)
 	    
  val first3 = List(2, 3, 5, 7, 11, 13) take 3    //> first3  : List[Int] = List(2, 3, 5)
  
  val combine = List(List(1, 2), List(3, 4)).flatten
                                                  //> combine  : List[Int] = List(1, 2, 3, 4)
  
  List(4, 5, 6).fold(0)(  (a:Int,b:Int) => a + b )//> res7: Int = 15

	List(4, 5, 6).foldLeft(0)( (a:Int,b:Int) => a + b )
                                                  //> res8: Int = 15
                                                

  List(4, 5, 6).reduce((a:Int,b:Int) => a + b )   //> res9: Int = 15
	
	List(4, 5, 6).reduceLeft((a:Int,b:Int) => a + b)
                                                  //> res10: Int = 15
                                                

	List(4, 5, 6).reduceRight((a:Int,b:Int) => a + b)
                                                  //> res11: Int = 15
                                                 
  }