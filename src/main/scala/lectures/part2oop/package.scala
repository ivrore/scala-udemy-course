package main.scala.lectures

package object part2oop {
  /*
  * A package can only have one package object of the name of the package,
  * accessible by package.scala and we can define methods to be accessible by all classes
  * and objects of the package */

  def sayHello: Unit = println("Hello, Scala")
  val SPEED_OF_LIGHT = 299792458
}
