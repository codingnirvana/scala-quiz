package codejam

import challenges.FileHelper

object Pancakes extends App {


  def solve(plates: Array[Int]) = rec(plates)

  def rec(a: Array[Int]) : Int = {
    if (a.length == 0 )
      0
    else {
      var res = 1500
      if (a.max <= 2) {
        a.max
      }
      else {
        val b = special(a, 2)
        res = Math.min(res, 1 + rec(b.get))
        val c = special(a, 3)
        if (c.isDefined)
          res = Math.min(res, 1 + rec(c.get))
        res = Math.min(res, 1 + rec(eat(a)))
        res
      }
    }
  }

  def eat(a:  Array[Int]) =  a.map(_ - 1).filter(_ > 0)

  def special(a: Array[Int], by: Int) = {
    val sorted = a.filter(_ > 0).sorted.reverse
    val max = sorted.head
    if (by == 3 && (max != 9 && max != 8)) {
      None
    } else {
      val (x, y) = (max / by, max - max / by)
      val b = sorted.tail ++ Array(x, y)
      Some(b.sorted.reverse)
    }
  }

  def run() {
    val fileName = "B-sample"
    val (t, lines) = FileHelper.readLines(s"input/qualification/$fileName.in")
    val result = (0 to t - 1).map { (index) =>
      val plates = lines(index * 2 + 1).split(" ").map(_.toInt)
      "Case #" + (index  + 1) + ": " + Pancakes.solve(plates)
    }
    FileHelper.writeLines(s"output/qualification/$fileName.out", result)
  }

  run()

}
