package objektwerks

import java.io.{File, PrintWriter}

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.imagemap.{ImageMapUtils, ToolTipTagFragmentGenerator, URLTagFragmentGenerator}
import org.jfree.chart.util.ExportUtils
import org.jfree.data.general.DefaultPieDataset

import scala.util.Try
import scala.util.control.NonFatal

object Chart:
  def build(): String =
    Try {
      exportChart( buildChart() )
    }.recover {
      case NonFatal(e) =>
        println(e)
        s"<p>Charing build error: ${e.getCause().getMessage()}</p>"
    }.get

  private def buildChart(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 20.0)
    dataset.setValue("IPA", 70.0)
    dataset.setValue("DIPA", 10.0)
    ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

  private def exportChart(chart: JFreeChart): String =
    val file = File("chart.png")
    ExportUtils.writeAsPNG(chart, 600, 400, file)

    val info = ChartRenderingInfo( StandardEntityCollection() )

    val tooltip = new ToolTipTagFragmentGenerator() {
                    override def generateToolTipFragment(value: String) = value
                  }

    val url = new URLTagFragmentGenerator() {
                override def generateURLFragment(value: String) = value
              }

    val writer = PrintWriter(file)

    ImageMapUtils.writeImageMap(writer, "image-map-chart", info, tooltip, url)

    val imagemap = ""
    writer.write(imagemap)
    imagemap