package objektwerks

import java.io.FileInputStream

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.VBox
import scalafx.scene.web.WebView


final class View:
  val chartInfo = Chart.build()

  val file = FileInputStream(chartInfo.imageUrl)
  val image = Image(file)
  val imageView = ImageView(image) // Works!

  val webView = WebView()
  webView.getEngine().load( chartInfo.imageUrl ) // Fails to load!
  // ImageMap is empty! webView.getEngine().loadContent( chartInfo.imageMap, "text/html" )

  val rootPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(imageView, webView)

  val scene = new Scene:
    root = rootPane