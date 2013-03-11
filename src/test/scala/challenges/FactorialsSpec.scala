package challenges

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class FactorialsSpec extends FlatSpec with ShouldMatchers{

  "Factorials" should "work with example test cases" in {
    val factorials = new Factorials
    factorials.solve(1) should equal (1)
    factorials.solve(2) should equal (2)
    factorials.solve(18) should equal (8)
    factorials.solve(26) should equal (4)
    factorials.solve(125) should equal (8)
    factorials.solve(3125) should equal (2)
    factorials.solve(9999) should equal (8)
  }

}
