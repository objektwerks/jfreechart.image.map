package objektwerks

import java.io.File

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.imagemap.{ImageMapUtils, ToolTipTagFragmentGenerator, URLTagFragmentGenerator}
import org.jfree.chart.util.ExportUtils
import org.jfree.data.general.DefaultPieDataset

import scala.util.Try
import scala.util.control.NonFatal

type ImageMap = String
type ImageUrl = String

final case class ChartInfo(imageMap: ImageMap, imageUrl: ImageUrl)

object Chart:
  val imageUrl = "./target/styles-chart.png"

  def build(): ChartInfo =
    val imageMap = Try {
      val chart = buildChart()
      persistChart(chart, imageUrl)
      buildImageMap()
    }.recover {
      case NonFatal(error) =>
        println(error)
        s"<p>Chart build error: ${error.getCause().getMessage()}</p>"
    }.get
    println(imageMap)
    println(imageUrl)
    ChartInfo(imageMap, imageUrl)

  private def buildChart(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 20.0)
    dataset.setValue("IPA", 70.0)
    dataset.setValue("DIPA", 10.0)
    ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

  private def persistChart(chart: JFreeChart, chartPath: String): Unit =
    val file = File(chartPath)
    ExportUtils.writeAsPNG(chart, 400, 400, file)

  private def buildImageMap(): ImageMap =
    val renderingInfo = ChartRenderingInfo( StandardEntityCollection() )

    val tooltipGenerator = new ToolTipTagFragmentGenerator() {
      override def generateToolTipFragment(value: String) = s"style = `$value`"
    }

    val urlGenerator = new URLTagFragmentGenerator() {
      override def generateURLFragment(value: String) = s"href = `$value`"
    }

    ImageMapUtils.getImageMap("imageMap", renderingInfo, tooltipGenerator, urlGenerator)