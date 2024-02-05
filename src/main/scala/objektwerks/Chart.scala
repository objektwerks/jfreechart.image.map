package objektwerks

import java.io.{File, PrintWriter, StringWriter}

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.imagemap.{ImageMapUtils, ToolTipTagFragmentGenerator, URLTagFragmentGenerator}
import org.jfree.chart.util.ExportUtils
import org.jfree.data.general.DefaultPieDataset

import scala.util.Try
import scala.util.control.NonFatal

type ImageMap = String

object Chart:
  def build(): ImageMap =
    val imageMap = Try {
      exportChart( buildChart() )
    }.recover {
      case NonFatal(error) =>
        println(error)
        s"<p>Chart build error: ${error.getCause().getMessage()}</p>"
    }.get
    println(s"image map: $imageMap")
    imageMap

  private def buildChart(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 20.0)
    dataset.setValue("IPA", 70.0)
    dataset.setValue("DIPA", 10.0)
    ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

  private def exportChart(chart: JFreeChart): String =
    val renderingInfo = ChartRenderingInfo( StandardEntityCollection() )

    val tooltipGenerator = new ToolTipTagFragmentGenerator() {
      override def generateToolTipFragment(value: String) = value
    }

    val urlGenerator = new URLTagFragmentGenerator() {
      override def generateURLFragment(value: String) = value
    }

    val file = File("./target/image-map-chart.png")
    ExportUtils.writeAsPNG(chart, 400, 400, file)

    val reader = StringWriter()
    val writer = PrintWriter(reader)

    ImageMapUtils.writeImageMap(writer, "image-map-chart.png", renderingInfo, tooltipGenerator, urlGenerator)
    writer.flush()
    reader.toString()