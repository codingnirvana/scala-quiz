package challenges

object CheckFunction extends App {

  def solve(s: String): Int =  {
    val lookup = Array(6,2,5,5,4,5,6,3,7,6)
    s.foldLeft(0)((res, c) => res + lookup(c - '0'))
  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/checkFunction.in")
    val result =  lines.zipWithIndex.map { case ( element, index ) => "Case #" + index + ": " + CheckFunction.solve(element)  }
    FileHelper.writeLines("output/checkFunction.out", result)
  }

  run()
}
