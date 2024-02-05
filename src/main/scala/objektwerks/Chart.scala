package objektwerks

import java.io.File

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.util.ExportUtils
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator
import org.jfree.data.general.DefaultPieDataset

object Chart:
  def build(): JFreeChart =
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


    chart