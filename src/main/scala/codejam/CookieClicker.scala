package codejam

import challenges.FileHelper

object CookieClicker extends App {

  def solve(c: Double, f: Double, g: Double ) = {

    def rec(goal: Double, currentFarm: Double, turns: Int) : Double = {
      if (turns > 10000) {
        return 0d
      }
      val first = goal / currentFarm
      var second = c/currentFarm + rec(goal, currentFarm + f, turns + 1)
      Math.min( first, second)
    }
    rec(g,2,0)
  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/qualification/B-small-attempt2.in")
    val result = (0 to t - 1).map {
      (index) =>
         val a = lines(index).split(" ").map(_.toDouble)
        "Case #" + (index  + 1) + ": " + "%.7f".format(CookieClicker.solve(a(0), a(1) ,a(2) )) }
    FileHelper.writeLines("output/qualification/B-small.out", result)
  }

  run()
}
