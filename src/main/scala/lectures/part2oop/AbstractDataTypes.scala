package main.scala.lectures.part2oop

object AbstractDataTypes extends App{

  // abstract
  abstract class Animal{
    // no values for creatureType or eat because the sub-classes implements them
    // they can't be instantiated because of no values
    val creatureType: String = "wild" // non-abstract member
    def eat: Unit // abstract member
  }

  class Dog extends Animal{
    // when super class is abstract, only possibility to change values is to override
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits -> can be mixed as much as needed
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // abstract classes vs traits
  // abstract classes and traits can have both abstract and non-abstract members
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class (single class inheritance but multiple treats inheritance)
  // 3 - traits = behavior, abstract class = "thing"
}
