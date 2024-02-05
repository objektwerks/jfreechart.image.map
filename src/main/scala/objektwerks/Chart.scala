package objektwerks

import java.io.{File, PrintWriter, StringWriter}

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.imagemap.ImageMapUtils
import org.jfree.chart.util.ExportUtils
import org.jfree.data.general.DefaultPieDataset

import scala.util.Try
import scala.util.control.NonFatal

object Chart:
  def build(): String =
    Try {
      exportChart( buildChart() )
    }.recover {
      case NonFatal(error) =>
        println(error)
        s"<p>Charing build error: ${error.getCause().getMessage()}</p>"
    }.get

  private def buildChart(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 20.0)
    dataset.setValue("IPA", 70.0)
    dataset.setValue("DIPA", 10.0)
    ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

  private def exportChart(chart: JFreeChart): String =
    val renderingInfo = ChartRenderingInfo( StandardEntityCollection() )

    val file = File("./target/chart.png")
    ExportUtils.writeAsPNG(chart, 400, 400, file) // Works correctly!

    val reader = StringWriter()
    val writer = PrintWriter(reader)

    ImageMapUtils.writeImageMap(writer, "image-map-chart", renderingInfo)
    writer.flush()

    val map = reader.toString()
    println(s"image map: $map") // Doesn't work correctly! image map: <map id="image-map-chart" name="image-map-chart"></map>
    map