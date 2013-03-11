package challenges

class Factorials {

  def solve(n: Int): Int = {
    (1 until n + 1).foldLeft(1)((res, i) => removeZeroes(res * i) % 100000 ) % 10
  }

  private def removeZeroes(n: Int): Int = {
//    n match {
//      case (n % 10 != 0) => n
//      case _ => removeZeroes(n)
//    }
    if (n % 10 != 0) {
      n
    } else {
      removeZeroes(n / 10)
    }
  }
}
