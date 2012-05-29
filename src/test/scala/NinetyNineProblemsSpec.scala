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



}
