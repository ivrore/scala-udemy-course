package main.scala.lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // use the type A
  }

  class MyMap[Key,Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList { // companion to class MyList
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
}
