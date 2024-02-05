package objektwerks

import org.jfree.chart.{ChartFactory, ChartRenderingInfo, JFreeChart}
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.data.general.DefaultPieDataset

object Chart:
  def build(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 30.0)
    dataset.setValue("IPA", 60.0)
    dataset.setValue("DIPA", 10.0)
    
    val chart = ChartFactory.createPieChart("Beer Styles", dataset, true, true, true)

    val renderingInfo = new ChartRenderingInfo( StandardEntityCollection() )

    
    chart