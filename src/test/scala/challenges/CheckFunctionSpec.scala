package challenges

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class CheckFunctionSpec extends FlatSpec with ShouldMatchers{

  "Check Function" should "work for example test cases" in {
    CheckFunction.solve("13579") should equal (21)
    CheckFunction.solve("02468") should equal (28)
    CheckFunction.solve("73254370932875002027963295052175") should equal (157)
  }
}
