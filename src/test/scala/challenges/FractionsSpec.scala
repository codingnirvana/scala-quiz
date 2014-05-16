package challenges

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class FractionsSpec extends FlatSpec with ShouldMatchers{

  "Fractions" should "work with example test cases" in {
    Fractions.solve(1,4) should equal (".(3)")
    //assert(Fractions.solve(1,4) == ".(3)")
    Fractions.solve(22, 5) should equal ("4.4")
    Fractions.solve(3, 8) should equal (".375")
    Fractions.solve(45, 56) should equal (".803(571428)")
    Fractions.solve(1, 7) should equal (".(142857)")
    Fractions.solve(11, 59) should equal (".(1864406779661016949152542372881355932203389830508474576271)")
  }
}
