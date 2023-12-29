package main.scala.lectures.part2oop

object InheritanceAndTraits extends App {
  //super class
  // single class inheritance = extends only one class at time
  class Animal{
    def eat = println("nomnom")
    val creatureType = "wild"
  }
  //sub-class
  class Cat extends Animal {
    def crunch ={
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  // extending a class means to inherit all variables and methods
  cat.crunch

  /*
  modifiers:
  - private = only for class declared
  - protected = only for class declared and sub-class
  - public = by default, but can be added
   */

  //constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name,0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name) // pass the parameters from the class is needed.
  // In this case only "name" because there is a complementary constructor with only the name

  // overriding
  /*
  class Dog(override val creatureType: String) extends Animal{
    override val creatureType = "domestic"
    override def eat = println("crunch, crunch")
  }
  dog.eat
  */
  class Dog(dogType: String) extends Animal {
    override val creatureType = dogType
    override def eat = {
      super.eat
    }
  }
  val dog = new Dog("K9")
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding - applying different implementation in the right classes
  // overloading - applying different methods with different signatures but with the same name in same class

  // super
  /*
  Preventing overrides:
   1. Use "final" on member
   2. Use "final" on class (erases possibility of "extends"
   3. Seal the class "sealed" - extend the classes in this file but prevent extending in another files
  */
}
