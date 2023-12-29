package main.scala.lectures.part2oop

object OOBasics extends App{
  val person = new Person ("John",26)
  println(person.age)
  person.greet("Edgar")
  person.greet()

  val author = new Writer("Edgar","Allan Poe", 1812)
  val impostor  = new Writer("Edgar","Allan Poe", 1812)
  val novel = new Novel("Best is yet to come",1854,author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc
  counter.inc.inc.inc
  counter.inc(10).inc.inc
}

class Person (name: String, val age: Int = 0) { // constructor
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // $name = parameter , $this.name = class val
  // overloading
  def greet(): Int = 42

  // multiple constructors
  def this(name: String) = this (name, 0) // instead doing this, better to set default value age = 0 in class parameter
  def this() = this("John Doe")
}

// class parameters are NOT FIELDS, instead we add val before name

/*

  Novel and a Writer
  Writer : first name, surname, year
  - method fullname

  Novel: name, year of release, author

  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel

*/

/*

  Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount

*/

class Writer (name: String, surname: String, val year: Int) {
  def getFullName: String = name + " " + surname

}
class Novel (name: String, year: Int, author: Writer){
  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int) = new Novel(name,newYear,author)

}

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1) // immutability, returns a new class instead of modifying the values
  }

  def dec = {
    println("Decrementing")
    new Counter(count + -1)
  }

  //def inc(n: Int) = new Counter(count + n)
  //def dec(n: Int) = new Counter(count - n)

  def inc(n: Int): Counter ={
    if (n<=0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

}


