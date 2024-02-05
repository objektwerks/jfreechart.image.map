package objektwerks

import java.io.File

import org.jfree.chart.{ChartFactory, ChartRenderingInfo}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.util.ExportUtils
import org.jfree.chart.imagemap.{ToolTipTagFragmentGenerator, URLTagFragmentGenerator}
import org.jfree.data.general.DefaultPieDataset
import org.jfree.chart.imagemap.ImageMapUtils

object Chart:
  def build(): String =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 30.0)
    dataset.setValue("IPA", 60.0)
    dataset.setValue("DIPA", 10.0)
    val chart = ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

    val file = File("chart.png")
    ExportUtils.writeAsPNG(chart, 600, 400, file)

    val info = ChartRenderingInfo( StandardEntityCollection() )
    val tooltip = new ToolTipTagFragmentGenerator() {
                    override def generateToolTipFragment(arg: String) = arg
                  }
    val url = new URLTagFragmentGenerator() {
                override def generateURLFragment(arg: String) = arg
              }
    ImageMapUtils.getImageMap("image-map-chart", info, tooltip, url)