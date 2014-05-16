package codejam

import challenges.FileHelper

object MagicTrick extends App{


  def solve(first: Int, second: Int, firstRows: List[Array[Int]], secondRows: List[Array[Int]]) = {
    val intersect: Array[Int] = firstRows(first - 1).intersect(secondRows(second - 1))
    intersect.size match {
      case 0 => "Volunteer cheated!"
      case 1 => intersect(0).toString
      case _ => "Bad magician!"
    }

  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/qualification/A-small-attempt0.in")
    val result = (0 to t - 1).map {
      (index) =>
        val start = index * 10
        val first = lines.slice(start, start + 1)(0).toInt
        val second = lines.slice(start + 5, start + 6)(0).toInt
      val firstRows = lines.slice(start + 1, start + 5).map(_.split(" ").map(_.toInt))
      val secondRows = lines.slice(start + 6, start + 10).map(_.split(" ").map(_.toInt))

        "Case #" + (index  + 1) + ": " + MagicTrick.solve(first, second, firstRows, secondRows) }
    FileHelper.writeLines("output/qualification/A-small.out", result)
  }

  run()

}
