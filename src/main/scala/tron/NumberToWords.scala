package tron

class NumberToWords {

  val singleDigitsMap = toLongMap(Map (0-> "zero", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven",
    8 -> "eight", 9-> "nine", 10 -> "ten"))

  val elevenToNineteenMap = toLongMap(Map (11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen",
    18 -> "eighteen", 19-> "nineteen"))

  val multipleOfTensMap = toLongMap(Map (10 -> "ten", 20 -> "twenty", 30 -> "thirty", 40 -> "forty", 50 -> "fifty", 60 -> "sixty", 70 -> "seventy",
    80 -> "eighty", 90-> "ninety"))

  val twoDigitMap = singleDigitsMap ++ elevenToNineteenMap ++ multipleOfTensMap

  val largeNumbersMap =  List (100L -> "hundred", 1000L -> "thousand", 1000000L -> "million", 1000000000L -> "billion", 1000000000000L -> "trillion")

  def solveForThreeDigits(number : Long) : String = {
    if (number == 0) {
      ""
    }
    else if (twoDigitMap.exists { case(k, v) => k == number }) {
      twoDigitMap(number)
    }
    else {
      val hundredsPlace = number / 100
      val tensPlace = (number/10)%10
      val unitsPlace = number % 10
      if (hundredsPlace == 0)
       twoDigitMap(tensPlace * 10) + " " + twoDigitMap(unitsPlace)
      else
       singleDigitsMap(hundredsPlace) + " hundred " + solveForThreeDigits(number % 100)
    }
  }

  def solveInternal(number: Long, xs : List[(Long, String)]) : String = {
    number match {
      case 0 => ""
      case n if n/1000 == 0 => solveForThreeDigits(n)
      case _ =>
        val (power, w) = xs.head
        if (number / power > 0) {
          solveForThreeDigits(number / power) + " "  + w + " " + solveInternal(number % power, xs.tail)
        } else {
          solveInternal(number , xs.tail)
        }
    }
  }

  def solve(number: Long) = {
    if (number == 0) {
      "zero"
    }  else {
      solveInternal(number, largeNumbersMap.reverse).trim()
    }
  }

  def toLongMap(m: Map[Int,String]) =  m.map { case (a,b) => a.toLong -> b}
}