package challenges

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class FactorialsSpec extends FlatSpec with ShouldMatchers{

  "Factorials" should "work with example test cases" in {
    Factorials.solve(1) should equal (1)
    Factorials.solve(2) should equal (2)
    Factorials.solve(18) should equal (8)
    Factorials.solve(26) should equal (4)
    Factorials.solve(125) should equal (8)
    Factorials.solve(3125) should equal (2)
    Factorials.solve(9999) should equal (8)
  }
}
