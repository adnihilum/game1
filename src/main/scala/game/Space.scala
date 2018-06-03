package game

import cats._
import cats.implicits._

case class Space (override val width: Int, override val height: Int)
  extends GenSpace[Cell](width, height, CellEmpty)

object Space {
  def apply(x:Int, y:Int): Space = new Space(x, y)
  implicit val show: Show[Space] = Show.show[Space]((x:Space) => {
    val y:GenSpace[Cell] = x
    y.show
  })
}

