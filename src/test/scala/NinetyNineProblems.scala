import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class NinetyNineProblemsSpec extends FlatSpec with ShouldMatchers {

  import Solution._
  "Ninety Nine Problems" should "P01 - Find the last element of a list" in {
    Problem1.last(List(1,1,2,3,5,8)) should equal (8)
  }

  it should "P02 - Find the last but one element of a list" in {
    Problem2.penultimate(List(1,1,2,3,5,8)) should equal (5)
  }

  it should "P03 - Find the kth element of a list" in {
    Problem3.nth(2, List(1,1,2,3,5,8)) should equal(2)
  }

}
