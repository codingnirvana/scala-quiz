import java.util.NoSuchElementException

object Solution {

  object Problem1 {
    def last[A](list: List[A]) = list.last

    def lastRecursive[A](list: List[A]) : A = list match {
      case head :: Nil => head
      case _ :: tail => lastRecursive(tail)
      case _ => throw new NoSuchElementException
    }
  }

  object Problem2 {
    def penultimateWithDropRight[A](list: List[A]) : A = {
      list.dropRight(1).last
    }

    def penultimateWithTakeRight[A](list: List[A]) : A = {
      list.takeRight(2).head
    }

    def penultimateRecursive[A](list: List[A]) : A = list match {
      case penultimate :: _ :: Nil => penultimate
      case _ :: tail => penultimateRecursive(tail)
      case _ => throw new NoSuchElementException
    }
  }

  object Problem3 {
    def nth[A](n: Int, list: List[A]) : A = {
       list(n)
    }

    def nthRecursive[A](n: Int, list: List[A]) : A = (n, list) match {
      case (0, h :: _) => h
      case (n, _ :: tail) => nthRecursive(n - 1, tail)
      case (_, Nil) => throw new NoSuchElementException
    }
  }

  object Problem4 {
    def length[A](list: List[A]) : Int = {
      list.size
    }

    def lengthRecursive(list: List[Int]) : Int = list match {
      case Nil => 0
      case _ :: tail => 1 + lengthRecursive(tail)
    }

    def lengthTailRecursive(list: List[Int]) = {
       def lengthTR(ans: Int, list: List[Int]) : Int = list match {
         case Nil => ans
         case _ :: tail => lengthTR(ans + 1, tail)
       }
      lengthTR(0, list)
    }
  }
}
