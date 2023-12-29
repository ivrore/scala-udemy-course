package lectures.part1basics

object CBNvsCBV extends App{
  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  def callByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
  callByValue(System.nanoTime()) // Evaluates the parameter only once, so equal all function
  callByName(System.nanoTime()) // "=>" evaluates parameter each time it appears in the functio

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

 // printFirst(infinite(),34) throws stack overflow
  printFirst(34,infinite()) // Delays the evaluation of infinite() until use, but as is not used it does not crash
}
