import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class NinetyNineProblemsSpec extends FlatSpec with ShouldMatchers {

  import Solution._

  val list: List[Int] = List(1, 1, 2, 3, 5, 8)

  "Ninety Nine Problems" should "P01 - Find the last element of a list" in {
    Problem1.last(list) should equal (8)
    Problem1.lastRecursive(list) should equal (8)
  }

  it should "P02 - Find the last but one element of a list" in {
    Problem2.penultimateWithDropRight(list) should equal (5)
    Problem2.penultimateWithTakeRight(list) should equal (5)
    Problem2.penultimateRecursive(list) should equal (5)
  }

  it should "P03 - Find the kth element of a list" in {
    Problem3.nth(2, list) should equal(2)
    Problem3.nthRecursive(2, list) should equal(2)
  }

  it should "P04 - Find the number of elements in a list" in {
    Problem4.length(list) should equal(6)
    Problem4.lengthRecursive(list) should equal(6)
    Problem4.lengthTailRecursive(list) should equal(6)
  }

  it should "P05 - Reverse a list" in {
    Problem5.reverse(list) should equal(List(8, 5, 3, 2, 1, 1))
    Problem5.reverseRecursive(list) should equal(List(8, 5, 3, 2, 1, 1))
    Problem5.reverseFunctional(list) should equal(List(8, 5, 3, 2, 1, 1))
  }

  it should "P06 - Find out whether a list is palindrome" in {
    Problem6.isPalindrome(list) should equal(false)
    Problem6.isPalindrome(List(1, 2, 3, 2, 1)) should equal(true)
  }

  it should "P07 - Flatten a nested list structure" in {
    Problem7.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should equal(list)
  }

  it should "P08 - Eliminate consecutive duplicates" in {
    Problem8.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should equal(List('a, 'b, 'c, 'a, 'd, 'e))
    Problem8.compressFunctional(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should equal(List('a, 'b, 'c, 'a, 'd, 'e))
  }

  it should "P09 - Pack consecutive duplicates into sub lists" in {
    Problem9.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should equal (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

}
