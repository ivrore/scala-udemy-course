package lectures.part1basics

object Expressions extends App {

  val x = 1+2
  println(x)
  println(2+2*4) // Math expression
  println(1 == x) // Evaluates true/false
  println(!(1 == x)) // 'Not' 1 equals x

  var aVariable = 4
  aVariable +=1 // changing a variable value is know as side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // If expression
  println (aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
  while (i<10) {
    i+=1
    println("This is number " + i)
  }

  // Everything in Scala is an expression

  val aWeirdValue = (aVariable = 3) // Unit === Void

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > y) "hello" else "goodbye"
    // The value of the block is the value of the last line in the block
  }
  println (aCodeBlock)
}
