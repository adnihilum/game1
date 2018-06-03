package game

import cats._
import cats.implicits._

class Path (space: Space, points: Seq[Point]) {
  def valid(): Boolean = {
    val isBlocked =
      (for (point <- points) yield {
        space.p(point) =!= CellEmpty
      }).fold(false)(_ || _)
    ! isBlocked
  }
}

object Path {
  def find(start:Point, end:Point) = {

  }
}
