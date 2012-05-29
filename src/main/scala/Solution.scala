import java.util.NoSuchElementException

object Solution {

  object Problem1 {
    def last[A](list: List[A]) = list.last

    def lastRecursive[A](list: List[A]) : A = list match {
      case head :: Nil => head
      case head :: tail => {
        System.out.println(head +  " tail:" + tail)
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
     def pack[A] (list: List[A]) = {
       list.foldRight(List[List[A]]()) { (h,r) =>
         if (!r.isEmpty && !r.head.isEmpty && r.head.head == h)
           r.head :: List(h) :: r.tail
         else
           List(h) :: r
       }
     }
  }
}
