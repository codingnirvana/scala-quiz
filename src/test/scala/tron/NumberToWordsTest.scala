package tron

import org.scalatest.FlatSpec
import org.scalatest.matchers.{ShouldMatchers, Matcher}

class NumberToWordsTest extends FlatSpec with ShouldMatchers {

  "Number To Words Test" should "return the correct words for single digit numbers" in {
    val numbersMap = Map (0-> "zero", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven",
    8 -> "eight", 9-> "nine")

    numbersMap.foreach {
      case (number, word) => new NumberToWords().solve(number) should equal(word)
    }
  }

  "Number To Words Test" should "return the correct words for eleven to twenty" in {
    val numbersMap = Map (11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen",
      18 -> "eighteen", 19-> "nineteen")

    numbersMap.foreach {
      case (number, word) => new NumberToWords().solve(number) should equal(word)
    }
  }

  "Number To Words Test" should "return the correct words for multiples of ten" in {
    val numbersMap = Map (10 -> "ten", 20 -> "twenty", 30 -> "thirty", 40 -> "forty", 50 -> "fifty", 60 -> "sixty", 70 -> "seventy",
      80 -> "eighty", 90-> "ninety")

    numbersMap.foreach {
      case (number, word) => new NumberToWords().solve(number) should equal(word)
    }
  }

  "Number To Words Test" should "return the correct words for all other two digit numbers" in {
    new NumberToWords().solve(21) should equal("twenty one")
    new NumberToWords().solve(77) should equal("seventy seven")
  }

  "Number To Words Test" should "return the correct words for hundred, thousand, millio etc" in {
    val numbersMap = Map (100L -> "hundred", 1000L -> "thousand", 1000000L -> "million", 1000000000L -> "billion", 1000000000000L -> "trillion")

    numbersMap.foreach {
      case (number, word) => new NumberToWords().solve(number) should equal("one " + word)
    }
  }

  "Number To Words Test" should "return the correct words for all three digit numbers" in {
    new NumberToWords().solve(621) should equal("six hundred twenty one")
    new NumberToWords().solve(787) should equal("seven hundred eighty seven")
    new NumberToWords().solve(406) should equal("four hundred six")
    new NumberToWords().solve(111) should equal("one hundred eleven")
    new NumberToWords().solve(390) should equal("three hundred ninety")
  }

  "Number To Words Test" should "return the correct words for all remaining numbers" in {
    new NumberToWords().solve(6011) should equal("six thousand eleven")
    new NumberToWords().solve(57633) should equal("fifty seven thousand six hundred thirty three")
    new NumberToWords().solve(92734230) should equal("ninety two million seven hundred thirty four thousand two hundred thirty")
    new NumberToWords().solve(3436454643L) should equal("three billion four hundred thirty six million four hundred fifty four thousand six hundred forty three")
    new NumberToWords().solve(432003436454643L) should equal("four hundred thirty two trillion three billion four hundred thirty six million four hundred fifty four thousand six hundred forty three")
  }
}
