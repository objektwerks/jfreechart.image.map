package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox
import scalafx.scene.web.WebView

final class View:
  val webView = WebView()
  val chartInfo = Chart.build()
  webView.getEngine().load( chartInfo.imageUrl )
  // ImageMap is empty! webView.getEngine().loadContent( chartInfo.imageMap, "text/html" )

  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(webView)

  val scene = new Scene:
    root = contentPane