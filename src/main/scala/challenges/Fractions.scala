package challenges

object Fractions extends App {

  def solve(n: Int, d: Int): String = {
    var b: List[Int] = Nil
    var c: List[Int] = List()

    var ans = ""

    var (n1, d1) = (n, d)
    if (n1 > d1) {
      ans += n1 / d1
      n1 %= d1
    }

    n1 *= 10

    while (!c.exists(i => i == n1)) {
      b :+= n1 / d1
      c :+= n1
      n1 = (n1 % d1) * 10
    }

    val index = c.indexOf(n1)

    if (b.length > 0) {
      ans += ".%s".format(b.take(index).mkString)
      if (n1 != 0) {
        ans += "(%s)".format(b.drop(index).mkString)
      }
    }
    ans
  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/fractions.in")

    val result = (1 to lines.length).map {
      index => {
        val numbers = lines(index - 1).split("\\s+").map(_.toInt)
        assert(2 == numbers.length)
        val (n, d) = (numbers(0), numbers(1))
        "Case #%d: %s".format(index, Fractions.solve(n, d))
      }
    }.toList

    FileHelper.writeLines("output/fractions.out", result)
  }

  run()
}
