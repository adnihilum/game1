package game

import cats._
import cats.implicits._

object ShowImplicits {

  // for Space
  implicit val spaceShow: Show[Space] = Show.show[Space]((x:Space) => {
    val y:GenSpace[Cell] = x
    y.show
  })

  // for Cell
  implicit val cellShow: Show[Cell] = Show.show[Cell] {
    case CellEmpty => "."
    case CellFull => "#"
  }

  // for GenSpace
  implicit def genSpaceShow[CellType: Show]:Show[GenSpace[CellType]] =
    Show.show[GenSpace[CellType]] ((s:GenSpace[CellType]) => {
      val prefix = s"space ${s.width} x ${s.height}\n"
      val body:String =
        (for{
          y <- 0 until s.height
          x <- 0 until s.width
        } yield {
          val cell:CellType = s.cells(s.idx(x, y))
          if(x == (s.width - 1)) cell.show ++ "\n"
          else cell.show
        }).foldLeft("")(_ ++ _)
      prefix + body
    })

  implicit val pathShow: Show[Path] =
    Show.show[Path] {case Path(space, points) => {
      ???

  }}
}
