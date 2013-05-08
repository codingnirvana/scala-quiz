object UnionFind extends App{

  case class Pair(first: Int, second: Int, weight: Float)

  def run() {
    val lines: Iterator[String] = io.Source.fromFile("/tmp/simple.txt").getLines()

    val allPairs: Iterator[Pair] = lines
      .map(_.split(','))
      .map(a => Pair(a(0).toInt, a(1).toInt, a(2).toFloat))

    val set = new DisjointSets[Int]()

    allPairs.foreach {
      p => {

        // println(set.size)

        (set.find(p.first), set.find(p.second)) match {
          case (Some(n1),Some(n2)) =>
            set.union(p.first,p.second)
          case (Some(n1),None) =>
            set.add(p.second)
            set.union(p.first,p.second)
          case (None, Some(n2)) =>
            set.add(p.first)
            set.union(p.first,p.second)
          case (None, None) =>
            set.add(p.first)
            set.add(p.second)
            set.union(p.first,p.second)
        }
      }
    }

    set.nodes
      .filter(n => n._2.parent == None)
      .foreach(n => println(s"${n._1} ${n._2}"))
  }

  run()

}
