package codejam

import challenges.FileHelper

object FairNSquare extends App {

  var m : List[Long] = List(1,4,9)

  def isPalindrome(i: Long) : Boolean = {
    val s = i.toString.toList

    def isPalindrome(list: List[Any]): Boolean = list match {
      case Nil => true
      case head :: Nil => true
      case head :: tail if head == tail.last => isPalindrome(tail.dropRight(1))
      case _ => false
    }

    isPalindrome(s)
  }

  def saveSquares() : List[Long] = {
    (10L to 10000000L).foreach {
      (x: Long) => if (isPalindrome(x) && isPalindrome(x * x)) m = x :: m
    }
    m
  }

  def solve(start: Long, end: Long): Int = {
    m.count((x) => start <=x && x <= end)
  }

  def run() {
    saveSquares()
    val fileName = "C-large-1"
    val (_, lines) = FileHelper.readLines("input/qualification/%s.in".format(fileName))
    val result =  lines.zipWithIndex.map {
      case ( element, index ) =>
        val split = element.split(" ")
        "Case #%d: %d".format(index + 1, FairNSquare.solve(split(0).toLong, split(1).toLong))
    }
    FileHelper.writeLines("output/qualification/%s.out".format(fileName), result)
  }

  // run()
  saveSquares()
  println(m)
}
