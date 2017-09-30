package com.funcpro.week4

object week4 {

  val info = (5, "Korben", true)                  //> info  : (Int, String, Boolean) = (5,Korben,true)

  val name = info._2                              //> name  : String = Korben

  val red = "red" -> "0xff0000"                   //> red  : (String, String) = (red,0xff0000)

  val reversed = red._2 -> red._1                 //> reversed  : (String, String) = (0xff0000,red)
  
  def printTuple(a:(Int,String,Boolean)) = {
  	println("First Item "+a._1);
  	println("Second Item "+a._2);
  	println("Third Item "+a._3);
  }                                               //> printTuple: (a: (Int, String, Boolean))Unit
  
  printTuple(info)                                //> First Item 5
                                                  //| Second Item Korben
                                                  //| Third Item true
  

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

  def sumInt(a: Int, b: Int) = sum(x => x, a, b)  //> sumInt: (a: Int, b: Int)Int
  def sumCube(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> sumCube: (a: Int, b: Int)Int

  //Anonymous functions
  val myFunct = (a: Int, b: Int) => if (a > b) a else b
                                                  //> myFunct  : (Int, Int) => Int = com.funcpro.week4.week4$$$Lambda$10/32114294
                                                  //| 2@2c6a3f77
  def sum2(f: Int => Int, a: Int, b: Int) = {
    //auxiliary function
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)

    loop(a, 0)
  }                                               //> sum2: (f: Int => Int, a: Int, b: Int)Int

  def doubleFunc(x: Int): Int = x * 2             //> doubleFunc: (x: Int)Int

  val myDoubleFunctionCopy: Int => Int = doubleFunc;
                                                  //> myDoubleFunctionCopy  : Int => Int = com.funcpro.week4.week4$$$Lambda$11/15
                                                  //| 66723494@1e67b872
  def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }                                               //> safeStringOp: (s: String, f: String => String)String

  sum2(x => x * x, 4, 5);                         //> res0: Int = 41

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(n, f(n))
  }                                               //> formatResult: (name: String, n: Int, f: Int => Int)String

  def performOps(args: Array[String]): Unit = {
    println(formatResult("factorial", 7, factorial))
  }                                               //> performOps: (args: Array[String])Unit

  def max(a: Int, b: Int) = if (a > b) a else b   //> max: (a: Int, b: Int)Int

  def operation(x: Int, y: Int, f1: (Int, Int) => Int) = {
    if (x != 0 & y != 0)
      f1(x, y)
    else 0
  }                                               //> operation: (x: Int, y: Int, f1: (Int, Int) => Int)Int

  operation(32, 8, max)                           //> res1: Int = 32

  operation(32, 8, (x: Int, y: Int) => if (x > y) x else y)
                                                  //> res2: Int = 32

  () => "Hello, World";                           //> res3: () => String = com.funcpro.week4.week4$$$Lambda$15/1874154700@614c551
                                                  //| 5

}