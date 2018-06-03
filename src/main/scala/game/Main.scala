package game
import cats._
import cats.implicits._

object Main extends App {
  val space = Space(10, 10)
  space(1,5) = CellFull
  println(space.show)
}
