package game

import cats._
import cats.implicits._

case class GenSpace[CellType] (width: Int, height: Int, defaultCell: CellType)
{
  val cells: Array[CellType] = new Array[CellType](width * height)

  def idx(x:Int, y:Int) = {
    if(x < 0 || x > width || y < 0 || y > height)
      throw new IndexOutOfBoundsException
    x + y * width
  }

  def apply(x: Int, y:Int): CellType = cells(idx(x,y))
  def update(x: Int, y:Int, cell:CellType): Unit = cells(idx(x, y)) = cell

  def p(p: Point):CellType = this(p.x, p.y)

  for{
    x <- 0 until width
    y <- 0 until height
  } {
    this(x, y) = defaultCell
  }

}

object GenSpace {
  implicit val spaceShow:Show[Space] = Show.show[Space] ((s:Space) => {
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

  def apply(width:Int, height: Int): Space = new Space(width, height)
}
