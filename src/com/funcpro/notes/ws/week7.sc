package com.funcpro.week4

object week7 {

  //Recap of last week lectures
  def sum(hof: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else hof(a) + sum(hof, a + 1, b)
  }                                               //> sum: (hof: Int => Int, a: Int, b: Int)Int

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
                                                  //> factorial: (n: Int)Int

  def squared(x: Int): Int = x * x                //> squared: (x: Int)Int

  def num(x: Int): Int = x                        //> num: (x: Int)Int
  def sumInts(a: Int, b: Int) = sum(num, a, b)    //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum(cube, a, b)  //> sumCubes: (a: Int, b: Int)Int
  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
  def sumSquareds(a: Int, b: Int) = sum(squared, a, b)
                                                  //> sumSquareds: (a: Int, b: Int)Int

  def selectBehaviour(choice: Int): (Int, Int) => Int = {
    if (choice == 1) {
      sumFactorials;
    } else if (choice == 2) {
      sumCubes
    } else {
      sumInts
    }
  }                                               //> selectBehaviour: (choice: Int)(Int, Int) => Int

  //Partially applied functions
  def operation(x: Int, y: Int, f: (Int, Int) => Int) = { f(x, y) }
                                                  //> operation: (x: Int, y: Int, f: (Int, Int) => Int)Int

  def opPartiallyApplied(x: Int, y: Int)(f: (Int, Int) => Int) = {
    f(x, y)
  }                                               //> opPartiallyApplied: (x: Int, y: Int)(f: (Int, Int) => Int)Int

  val partially = opPartiallyApplied(3, 5)_       //> partially  : ((Int, Int) => Int) => Int = com.funcpro.week4.week7$$$Lambda$8
                                                  //| /6738746@35bbe5e8

  val result = partially(selectBehaviour(1));     //> result  : Int = 150

  //Loop

  val oneToTen = 1 to 10                          //> oneToTen  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
  val onToTenBy2 = 1 to 10 by 2                   //> onToTenBy2  : scala.collection.immutable.Range = inexact Range 1 to 10 by 2
                                                  //| 
  val oneUntil10 = 1 until 10                     //> oneUntil10  : scala.collection.immutable.Range = Range 1 until 10

  //Printing of numbers from 1 to 10
  for (i <- 1 to 10) {
    println(i)                                    //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
  }

  for {
    i <- 1 to 10
  } {
    println(i)                                    //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
  }

  //Iterator Guard
  for (i <- 1 to 10; if i % 2 == 0; x2 = i * 2) println(x2)
                                                  //> 4
                                                  //| 8
                                                  //| 12
                                                  //| 16
                                                  //| 20

  //Value binding
  for (i <- 1 to 10; x2 = i * 2; if i % 2 == 0)
    println(x2)                                   //> 4
                                                  //| 8
                                                  //| 12
                                                  //| 16
                                                  //| 20
  val quote = "Faith,Hope,,Charity"               //> quote  : String = Faith,Hope,,Charity
  for {
    t <- quote.split(",")
    if t != null
    if t.size > 0
  } { println(t) }                                //> Faith
                                                  //| Hope
                                                  //| Charity



  val k = for {
    i <- 1 to 10
  	if(i % 2 ==0)
  } yield {
    i
  }
  
	for(i <- k){
		println(i)
	}
	



}