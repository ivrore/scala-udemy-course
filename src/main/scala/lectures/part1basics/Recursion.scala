package lectures.part1basics

import scala.annotation.tailrec

/**
 * Created by Iván on 09/12/2023
 */
object Recursion extends App{
  def factorialFunction(num: Int): Int = {

    if (num <= 0) 1
    else {
      println("Computing factorial of " + num + " - I first need factorial of " + (num-1))
      val result = num * factorialFunction(num - 1) // No tail  recursion because recursion is not the last expression
      println("Computed factorial of " + num)
      result
    }

  }
  println(factorialFunction(10))

  // This function solves the problem of computation on large numbers in before function
  // Does not throw stack overflow
  def anotherFactorial (num:Int): BigInt ={
    @tailrec //annotation to verify if is tail recursive
    def factHelper(x:Int, accumulator: BigInt): BigInt =
      if (x <=1) accumulator
      else factHelper(x-1,x*accumulator) // Tail recursion = use recursive call as the last expression
    factHelper(num,1)
  }

  /*
  anotherFactorial(10) = factHelper(10,1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)

  */
  println(anotherFactorial(5000))

  /*
  HINT: Use intermediate accumulators
  1. Concatenate a string n times
  2. IsPrime function tail recursive
  3. Fibonacci function, tail recursive
  */
  @tailrec
  def concatenateString(astr: String,n: Int, accumulator: String): String = {
    if (n<=0) accumulator
    else concatenateString(astr,n-1,astr + accumulator)
  }

  println(concatenateString("Raw ",5,""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int,isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n/2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n:Int): Int = {
    def fiboTailrec(i:Int, last: Int, nextToLast: Int): Int = //Fibonacci needs two accumulators, n-1 and n-2
      if (i>=n) last
      else fiboTailrec(i+1,last + nextToLast, last)

    if (n<= 2) 1
    else fiboTailrec(2,1,1)
  }
  println(fibonacci(8))

}
