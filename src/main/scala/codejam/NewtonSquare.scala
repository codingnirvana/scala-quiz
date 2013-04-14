package codejam

object NewtonSquare extends App{

  def abs(x:BigInt) = if (x < 0) -x else x

  def sqrtIter(guess: BigInt, x: BigInt): BigInt =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: BigInt, x: BigInt) =
    abs(guess * guess - x) < (x/10000000L)

  def improve(guess: BigInt, x: BigInt) =
    (guess + x / guess) / 2

  def sqrt(x: BigInt) = println(sqrtIter(BigInt(1), x))


  sqrt(BigInt(999998000000L))

}
