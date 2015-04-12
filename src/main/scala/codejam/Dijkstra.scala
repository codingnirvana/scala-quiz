package codejam

import challenges.FileHelper

object Dijkstra extends App{

  def solve(repeat: Int, letters: String) = {

  }


  def run() {
    val fileName = "C-sample"
    val (t, lines) = FileHelper.readLines(s"input/qualification/$fileName.in")
    val result = (0 to t - 1).map { (index) =>
      val repeat = lines(index * 2).split(" ")(1)_.toInt
      val letters = lines(index * 2 + 1)
      "Case #" + (index  + 1) + ": " + Dijkstra.solve(repeat, letters)
    }
    FileHelper.writeLines(s"output/qualification/$fileName.out", result)
  }

  run()


}
