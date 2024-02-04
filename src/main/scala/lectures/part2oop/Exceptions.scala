package main.scala.lectures.part2oop

import java.lang
import java.nio.BufferOverflowException

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^will crash with NPE

  // 1. Throwing exceptions

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes
  // Exception = Something that went wrong with the program (e.g. NullPointer)
  // Error = Something that went wrong with the system (e.g. Stack Overflow)

  // 2. How to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
    // changing 'RuntimeException' per 'NullPointerException' will show error
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  /*
  class MyException extends Exception
  val exception = new MyException

  throw exception
*/
  /*
    1. Crash your program with OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
  - add(x,y)
  - subtract(x,y)
  - multiply(x,y)
  - divide(x,y)

  Throw
  - OverflowException if add (x,y) exceedsInt.MAX_VALUE
  - UnderflowException if subtract (x,y) exceeds Int.MIN_VALUE
  - MathCalculationException for division by 0
  */

  //  1. Crash your program with OutOfMemoryError
  // OOM
  //val array = Array.ofDim[Int](Int.MaxValue)

  // 2. Crash with SOError
  // SO Error
  def infiniteRecursive: Int = 1 + infiniteRecursive
  //val noLimit = infiniteRecursive

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  // 3. PocketCalculator
  object PocketCalculator {
    def add (x: Int,y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract (x: Int,y: Int)= {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply (x: Int,y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def divide (x: Int,y: Int)={
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10)) -> This will throw SOError
  println(PocketCalculator.divide(3,0))


}