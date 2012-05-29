object Solution {

  object Problem1 {
    def last[A](list: List[A]) = {
      list.last
    }
  }

  object Problem2 {
    def penultimate[A](list: List[A]) = {
      list.dropRight(1).last
    }
  }

  object Problem3 {
    def nth[A](index: Int, list: List[A]) = {
         list(index)
    }
  }
}
