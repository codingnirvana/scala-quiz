package codejam

import challenges.FileHelper

object TicTacToe extends App{

  def solve(input: List[String]) : String = {
    if (hasWon(input, 'O')) "O won"
    else if (hasWon(input, 'X')) "X won"
    else if (hasCompleted(input)) "Draw"
    else "Game has not completed"
  }

  def hasWon(input: List[String], player: Char) : Boolean = {
    val board = input.toArray.map {_.toCharArray}

    def hasWon(r: Int, c:Int, dr: Int, dc: Int): Boolean = {
      if (r < 0 || c < 0 || r >= 4 || c >= 4)
         true
      else if (board(r)(c) == player || board(r)(c) == 'T')
         hasWon(r + dr, c + dc, dr ,dc)
      else false
    }

    var won = (0 to 3).foldLeft(false)( (won, x) => won || hasWon(x, 0, 0, 1) || hasWon(0, x, 1, 0))
    won |= hasWon(0,0,1,1)
    won |= hasWon(0,3,1,-1)
    won
  }

  def hasCompleted(input: List[String]) : Boolean = {
    val board = input.toArray.map {_.toCharArray}

    def hasCompleted(r: Int, c:Int): Boolean = {
      if (r >= 4 || c >= 4)
        true
      else if (board(r)(c) == '.')
        false
      else
        hasCompleted(r + 1, c) && hasCompleted(r, c + 1) && hasCompleted(r + 1, c + 1)
    }

    hasCompleted(0,0)
  }

  def run() {
    val (t, lines) = FileHelper.readLines("input/qualification/A-large.in")
    val result = (0 to t - 1).map { (index) => "Case #" + (index  + 1) + ": " + TicTacToe.solve(lines.slice(index * 5, index * 5 + 4)) }
    FileHelper.writeLines("output/qualification/A-large.out", result)
  }

  run()

}
