package main.scala.lectures.part4pm

object BracelessSyntax {

  // if - expressions
  val anIfExpresssion = if (2>3) "bigger" else "smaller"

  /// java-style
  val anIfExpression_v2 =
    if (2 >3) {
      "bigger"
    } else {
      "smaller"
    }

  // compact
  val anIfExpression_v3 =
    if (2> 3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpression_v4 =
    if 2 > 3 then
      "bigger" // higher indentation than the if part, python style
    else
      "smaller"

  val anIfExpression_v5 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

    // scala 4 one-liner
    val anIfExression_v6 = if 2 > 3 then "bigger" else "smaller"

    // for comprehensins
    val aForComprehension = for {
      n <- List(1,2,3)
      s <- List("black","white")
    } yield s"$n$s"

    // scala 3
    val aForComprehension_v2 =
      for
        n <- List(1, 2, 3)
        s <- List("black", "white")
      yield s"$n$s"

    // pattern matching
    val meaningOflife = 42
    val aPatternMatch = meaningOflife match {
      case 1 => "the one"
      case 2 => "double or nothing"
      case _ => "something else"
    }

    // scala 3
    val aPatternMatch_v2 =
      meaningOflife match
        case 1 => "the one"
        case 2 => "double or nothing"
        case _ => "something else"

  // methods without braces
  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 40



    partialResult + 2  // this is part of the function as well

  // class definition with significant indentation (same for traits, objects, enums, etc)
  class Animal: // compiler expects the body of Animal after the :
    def eat(): Unit =
      println("I'm eating")
      // end eat

    def grow(): Unit =
      println("I'm growing")

    // 3000 more lines of code in Animal class, add "end" token
  end Animal // if, match, for, methods, classes, traits, enums, objects

  // anonymous classes
  val aSpecialAnimal = new Animal:
    override def eat(): Unit = println("I'm special")

  // indentation = strictly larger indentation
  // 3 spaces + 2 tabs > 2 spaces + 2 tabs
  // 3 spaces + 2 tabs > 3 spaces + 1 tab
  // 3 tabs + 2 spaces ??? 2 tabs + 3 spaces

  def main(args: Array[String]): Unit = {
    println(anIfExpression_v5)
  }
}
