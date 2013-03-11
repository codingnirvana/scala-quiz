package challenges

object Factorials extends App{

  def solve(n: Int): Int = {
    (1 until n + 1).foldLeft(1)((res, i) => removeZeroesWithPatternMatching(res * i) % 100000 ) % 10
  }

  private def removeZeroesWithIf(n: Int) : Int = {
    if (n % 10 != 0) {
      n
    } else {
      removeZeroesWithIf(n / 10)
    }
  }

  private def removeZeroesWithPatternMatching(n: Int): Int = {
    n match {
      case _ if (n % 10 != 0) => n
      case _ => removeZeroesWithPatternMatching(n/10)
    }
  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/factorials.in")
    val result =  lines.zipWithIndex.map { case ( element, index ) => "Case #" + index + ": " + Factorials.solve(element.trim.toInt)  }
    FileHelper.writeLines("output/factorials.out", result)
  }

  run()
}
