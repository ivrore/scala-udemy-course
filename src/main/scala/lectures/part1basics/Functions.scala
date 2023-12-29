package lectures.part1basics

object  Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Peter is", 49))

  def parameterlessFunction(): Int = 45

  /* If we remove the return type from a normal function, compiler interprets return type.
   This doesn't work for recursive functions */

  def normalFunction() = {
    32 + "String"
  }

  // When you need loops, write recursive functions
  // Recursive function
  def repeatedFunction(astr: String, n: Int): String = {
    if (n == 1) astr
    else astr + repeatedFunction(astr, n - 1)
  }

  println(repeatedFunction("hello ", 3))


  // Function with side Effects, for example, using unit
  // Unit is used for side effects, for example, with something printed on console, display something on screen, write to file...
  def sideEffects(aString: String): Unit = println(aString)

  def bigFunction(n: Int): Int = {
    def smallFunction(a: Int, b: Int): Int = a + b

    smallFunction(n, n - 1)
  }

  println(bigFunction(4))

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 * .. * n
  */

  def greetingFunction(name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and I am " + age + " years old")
  }

  greetingFunction("Josh", 32)

  def factorialFunction(num: Int): Int = {

    if (num <= 0) 1
    else num * factorialFunction(num - 1)

  }

  println(factorialFunction(5)) //120


  def fibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
  }
  println(fibonacciFunction(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t<=1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println(isPrime(37))
}
