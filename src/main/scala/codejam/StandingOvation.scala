package codejam

import challenges.FileHelper

object StandingOvation extends App {

  def solve(shyness : Array[Int]) = {
    var standingSoFar = 0
    var res = 0
    for ((s, index) <- shyness.zipWithIndex) {
      val diff = index - standingSoFar
      if (diff > 0) {
        res += diff
        standingSoFar += diff
      }
      standingSoFar += s
    }
    res
  }


  def run() {
    val fileName = "A-large"
    val (t, lines) = FileHelper.readLines(s"input/qualification/${fileName}.in")
    val result = (0 to t - 1).map { (index) =>
      val splits = lines(index).split(" ")
      "Case #" + (index  + 1) + ": " + StandingOvation.solve(splits(1).split("").drop(1).map(_.toInt))
    }
    FileHelper.writeLines(s"output/qualification/${fileName}.out", result)
  }

  run()

}
