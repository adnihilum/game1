package game.gui
import scala.swing._

class UI extends MainFrame {
  title = "game1"
  preferredSize = new Dimension(640, 480)
  contents = new Label("I was here, kek...")
}

object MainWindow extends App {
  val ui = new UI
  ui.visible = true
  println("done")
}
