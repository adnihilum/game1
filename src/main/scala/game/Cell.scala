package game

import cats._
import cats.implicits._

sealed trait Cell

object Cell {
  implicit val cellEq: Eq[Cell] = Eq.instance[Cell] { _ == _ }
}

object CellEmpty extends Cell
object CellFull extends Cell
