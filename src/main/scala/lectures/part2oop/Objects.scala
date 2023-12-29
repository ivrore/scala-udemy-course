package main.scala.lectures.part2oop

object Objects extends App{

  // Scala does not have the concept of class-level functionality ("static")
  // Instead it has objects, that is a similar kind "static" functionality

  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    // factory method
    def from(mother: Person, father: Person): Person ={
      new Person("Bobbie")
    }
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // class/object Person are companions
  // can access each other's private members
  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance)
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobbie = Person.from(mary,john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
