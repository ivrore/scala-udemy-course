package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42;
  println(x);
  val aString : String = "hello";
  val anotherString = "goodbye";
  val aBoolean : Boolean = true;
  val aChar : Char = 'a' // accepts simple commas
  val aShort : Short = 45 // for short numbers
  val aLong : Long = 456344324523424L // used for large numbers, needs L at final
  val aFloat : Float = 34.3f
  val aDouble : Double = 44.4534632

  var aVariable : Int = 4

  aVariable = 5 // In this case we can change value because it's variable not val. Side effects


  // 'Vals' are inmutable
  // Val typing is optional. Compiler infers types
}
