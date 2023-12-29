package main.scala.lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes (movie: String): Boolean = movie == favoriteMovie
    def +(age: Int): Int = age + 1
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name,favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala: String = this learns "Scala"
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

  }

  val mary = new Person ("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception" ) // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala

  val tom = new Person("Tom","Fight Club")
  println(mary + tom) // class + method + methodParameter

  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_~
  // unary_ prefix only works with  - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent without parameters to apply() function

  /*
  1. Overload the operator
  mary + "The rockstar" => new Person "Mary (The rockstar)"

  2. Add an age to the Person class
  Add a unary + operator => new Person with the age +1
  +mary => mary with the age incrementer
  3. Add a "learns" method in the Person class => "Mary learns scala"
  Add a learnScala method, calls learns method with "Scala"
  Use it in postfix notation
  4. Overload the apply method
  mary.apply(2) => "Mary watched Inception 2 times"
  */

  // 1. Overload the operator
  println((mary + "The Rockstar")()) // Last () to apply the method "apply" from Person class
  // same as .apply()

  // 2. Add an age to the Person class
  println(+mary + 27)

  // 3. Add a "learns" method
  println(mary learnsScala)

  // 4. Overload the apply method
  println(mary.apply(2))


}
