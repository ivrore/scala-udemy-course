package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toLowerCase()+" / "+ str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // +: for prepending and :+ for appending operators (Scala specific
  println(str.reverse) // Scala specific
  println(str.take(2))

  // Scala-specific: String interpolators.

  // S-interpolators
  val name = "Josh "
  val age = 12
  val greeting = s"Hello, my name is $name and I am ${age + 20} years old" // adding 's' at the start
  println(greeting)

  // F-interpolators
  val speed: Float = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline") //Print characters without escaping them
}
