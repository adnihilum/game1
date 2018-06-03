package game

case class Space (override val width: Int, override val height: Int)
  extends GenSpace[Cell](width, height, CellEmpty)

object Space {
  def apply(x:Int, y:Int): Space = new Space(x, y)
}
