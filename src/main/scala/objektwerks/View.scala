package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox
import scalafx.scene.web.WebView

final class View:
  val webView = WebView()
  webView.getEngine().loadContent( Chart.build() )

  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(webView)

  val scene = new Scene:
    root = contentPane