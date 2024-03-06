package main.scala.lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10 // also 'until' to not include 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // List
  val aList = List(1,2,3)
  val prepended = 42 :: aList // :: to add to a list
  val appendPrepend = 42 +: aList :+ 89
  println(prepended)
  println(appendPrepend)

  val apples5 = List.fill(5)("apple") // fill 5 times in list with string
  println(apples5)
  println(aList.mkString("-|-")) // pretty print a list with custom separator

  // Array
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // Initialise array with not null,
                                              // but default values for primitive types int, double, boolean...
                                              // for string type = Null
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers //  implicit conversion Array to a WrappedArray/ArraySeq
  println(numbersSeq)

  // Vector
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <-  1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt()) // operation
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  // Pros/Cons
  // List
  // + Keeps reference to tail
  // - updating an element in the middle takes long
  println(getWriteTime(numbersList))
  // Vector
  // + depth of the tree is small
  // - needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector ))

}
