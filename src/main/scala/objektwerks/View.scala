package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox
import scalafx.scene.web.WebView

final class View:
  val chartInfo = Chart.build()
  val webView = WebView()
  webView.getEngine().load( chartInfo.imageUrl )
  // ImageMap is empty! webView.getEngine().loadContent( chartInfo.imageMap, "text/html" )

  val rootPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(webView)

  val scene = new Scene:
    root = rootPane