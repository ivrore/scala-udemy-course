package main.scala.exercises


abstract class MyList[+A]{

  /*
  head = first element of the list
  tail = reminder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
  */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

}
// linked list
object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element,Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B]  = new Cons(element,this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object ListTest extends App {
  /*
  val list = new Cons(1,new Cons(2, new Cons(3, Empty)))
  println(list.tail.head) // 2
  println(list.add(4).head) // 4
  println(list.isEmpty) // false
  println(list.toString) // [1 2 3]
  */

  val listOfIntegers: MyList[Int] = new Cons(1,new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello",new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

}


