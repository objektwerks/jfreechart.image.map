package objektwerks

import org.jfree.chart.{ChartFactory, JFreeChart}
import org.jfree.data.general.DefaultPieDataset

object ImageMapChart:
  def build(): JFreeChart =
    val dataset = new DefaultPieDataset[String]()
    dataset.setValue("Pale Ale", 30.0)
    dataset.setValue("IPA", 60.0)
    dataset.setValue("DIPA", 10.0)
    
    val chart = ChartFactory.createPieChart("Soft Drink Pie Chart", dataset, true, true, true)
    chart