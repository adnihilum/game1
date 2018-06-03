package game

import cats._
import cats.implicits._

sealed trait Cell

object Cell {
  implicit val cellShow: Show[Cell] = Show.show[Cell] {
    case CellEmpty => "."
    case CellFull => "#"
  }

  implicit val cellEq: Eq[Cell] = Eq.instance[Cell] { _ == _ }
}

object CellEmpty extends Cell
object CellFull extends Cell
