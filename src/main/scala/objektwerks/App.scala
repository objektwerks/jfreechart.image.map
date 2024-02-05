package objektwerks

import scalafx.application.JFXApp3

object App extends JFXApp3:
  override def start(): Unit =
    val view = View()
    stage = new JFXApp3.PrimaryStage {
      scene = view.scene
      title = "JfreeChart Image Map"
    }
    println("*** JFreeChart Image Map app started.")

  override def stopApp(): Unit = println("*** JFreeChart Image Map app stopped.")