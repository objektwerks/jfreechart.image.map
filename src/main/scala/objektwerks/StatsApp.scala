package objektwerks

import com.typesafe.scalalogging.LazyLogging

import scalafx.application.JFXApp3

object StatsApp extends JFXApp3 with LazyLogging:
  override def start(): Unit =
    val view = StatsView()
    stage = new JFXApp3.PrimaryStage {
      scene = view.scene
      title = "Stats"
    }
    logger.info("*** Stats app started.")

  override def stopApp(): Unit = logger.info("*** Stats app stopped.")