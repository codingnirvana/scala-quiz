import scala.util.Random

case class Grid(width: Int, height: Int)  {
  var walls = List[(Int, Int)]()
  var players = List[(Int, Int)]()
  def addWall(x: Int, y: Int) = walls = (x,y) :: walls
  def addPlayer(x: Int, y:Int) = players = (x,y) :: players

  def canMove(p: Position) = !walls.contains((p.x,p.y)) && !players.contains((p.x,p.y))
  def isWall(p: Position) = walls.contains((p.x,p.y))
}


case class Position(x: Int, y: Int, direction: String = "") {
  def left = Position((x - 1 + 30) % 30, y, "LEFT")
  def right = Position((x + 1 + 30) % 30, y, "RIGHT")
  def down = Position(x, (y + 1 + 20) % 20, "DOWN")
  def up = Position(x, (y - 1 + 20) % 20, "UP")

  def neighbors = List(left, right, down, up)
}



object Player {
  def main(args: Array[String]) {
    // Read init information from standard input, if any
    val w = readLine().toInt

    val grid = Grid(30, 20)


    (1 to w).foreach { i =>
      val walls = readLine().split(" ")
      grid.addWall(walls(0).toInt, walls(1).toInt)
    }



    while (true) {
      // Read information from standard input
      val n = readLine()
      val N = n.split(" ")(0).toInt
      val myNumber = n.split(" ")(1).toInt

      val positions = (1 to N).map {
        i =>
          val splits = readLine().split(" ")
          (splits(0).toInt, splits(1).toInt, splits(2).toInt, splits(3).toInt)
      }.toList

      positions.map {
        p =>
        // grid.addPlayer(p._1, p._2)
          grid.addPlayer(p._3, p._4)
      }

      val current = Position(positions(myNumber)._3, positions(myNumber)._4)

      val possibleMoves = Random.shuffle(current.neighbors).filter {
        p => grid.canMove(p) && p.neighbors.exists(grid.isWall)
      } ++ Random.shuffle(current.neighbors).filter(grid.canMove)

      possibleMoves.head.direction
    }

  }
}