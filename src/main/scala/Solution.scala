import java.util.NoSuchElementException
import scala.Either

object Solution {

  object Problem1 {
    def last[A](list: List[A]) = list.last

    def lastRecursive[A](list: List[A]) : A = list match {
      case head :: Nil => head
      case head :: tail => {
        lastRecursive(tail) }
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

  object Problem5 {
    def reverse[A](list: List[A]) = {
      list.reverse
    }

    def reverseRecursive[A](list: List[A]) = {
      def reverseTR(ans: List[A], list: List[A]) : List[A] = list match {
        case Nil => ans
        case h :: tail  =>  reverseTR(h :: ans, tail)
      }
      reverseTR(Nil, list)
    }

    def reverseFunctional[A](list: List[A]) : List[A] = {
      list.foldLeft(List[A]()) {(r,h) => h :: r}
    }
  }

  object Problem6 {
    def isPalindrome[A](list: List[A]) : Boolean = {
      list.equals(list.reverse)
    }
  }

  object Problem7 {
    def flatten[A](list: List[A]) : List[Any]  = list flatMap {
      case l : List[_] => flatten(l)
      case e => List(e)
    }
  }

  object Problem8 {
    def compress[A](list: List[A]) = {
       def compressTR(current: A, ans: List[A], list: List[A]) : List[A] = list match {
         case Nil => ans
         case `current` :: tail => compressTR(current, ans, tail)
         case head :: tail => compressTR(head, head :: ans, tail)
       }
      compressTR(list(0), List(list(0)), list).reverse
    }

    def compressFunctional[A](list: List[A]) = {
       list.foldRight(List[A]()) { (h,r) =>
          if (r.isEmpty || r.head != h)
            h :: r
          else
            r
       }
    }
  }

  object Problem9 {

    def pack[A](list: List[A]): List[List[A]] = {
      if (list.isEmpty) List(List())
      else {
        val (packed, next) = list span { _ == list.head }
        if (next == Nil) List(packed)
        else packed :: pack(next)
      }
    }

    def packFunctional[A](list: List[A]) = {
       list.foldRight(List[List[A]]()) { (h,r) =>
         if (!r.isEmpty && r.head.head == h)
           (h :: r.head) :: r.tail
         else
           List(h) :: r
       }
     }
  }

  object Problem10 {
    def encode[A](list: List[A]) : List[(Int, A)] = {
      if (list.isEmpty) List()
      else {
        val (packed, next) = list span { _ == list.head }
        (packed.size,packed.head) :: encode(next)
      }
    }

    def encodeFunctional[A](list: List[A]) = {
      Problem9.packFunctional(list) map { packed => (packed.size, packed.head)}
    }
  }

  object Problem11 {
    def encodeModified[A](list: List[A]) = {
      Problem10.encodeFunctional(list) map {
        case (1, b) => b
        case (a, b) => (a,b)
      }
    }

    def encodeModifiedTypeSafe [A](list: List[A]) : List[Either[A, (Int, A)]] = {
      Problem10.encodeFunctional(list) map {
        case (1, b) => Left(b)
        case (a, b) => Right(a,b)
      }
    }
  }

  object Problem12 {
     def decode[A](list: List[(Int,A)]) = {
        list flatMap { t => List.fill(t._1)(t._2)}
     }
  }

  object Problem14 {
    def duplicate[A](list: List[A])= {
      Problem15.duplicateN(2,list)
    }
  }

  object Problem15 {
    def duplicateN[A](n:Int, list: List[A])= {
      list flatMap { x => List.fill(n)(x)}
    }
  }

}
