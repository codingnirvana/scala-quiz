package challenges

class CheckFunction {

  def solve(s: String)  =  {
    val lookup = Array(6,2,5,5,4,5,6,3,7,6)
    s.foldLeft(0)((res, c) => res + lookup(c - '0'))
  }

}
