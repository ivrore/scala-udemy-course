package main.scala.lectures.part2oop

import main.scala.playground._ //{PrincessCharming, Cinderella => Princess}
import java.sql.Date
import java.util.{Date => UtilDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Ivan","RockTheJVM",2024)

  // import the package
  val princess = new Cinderella // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object, rarely used but could be useful sometime
  sayHello
  println(s"This is the speed of light: ${SPEED_OF_LIGHT}")

  // imports
  val prince = new PrinceCharming

  // 1. Use FQ names
  val date = new UtilDate
  val sqlDate = new java.sql.Date(2018, 5, 4)

  // 2. Use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
