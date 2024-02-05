package objektwerks

import javafx.scene.{chart => jfxsc}

import Stats.*

import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.chart.{NumberAxis, ScatterChart, XYChart}
import scalafx.scene.control.Label
import scalafx.scene.layout.{HBox, VBox}

final class StatsView:
  private def buildScatterChartData(): ObservableBuffer[jfxsc.XYChart.Series[Number, Number]] =
    val model = new ObservableBuffer[jfxsc.XYChart.Series[Number, Number]]()

    val xsSeries = new XYChart.Series[Number, Number] { name = "xs" }
    xs.foreach { x => xsSeries.data() += XYChart.Data[Number, Number](x, x) }

    val ysSeries = new XYChart.Series[Number, Number] { name = "ys" }
    ys.foreach { y => ysSeries.data() += XYChart.Data[Number, Number](y, y) }

    model += xsSeries
    model += ysSeries
    model

  val xs = Vector[Double](1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
  val ys = Vector[Double](1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)

  val dataLabel = new Label:
    id = "data-label"
    text = "Data"
    padding = Insets(3)

  val xsLabel = new Label:
    text = "xs: " + xs.mkString(", ")

  val ysLabel = new Label:
    text = "ys: " + ys.mkString(", ")

  val scatterChart = ScatterChart(NumberAxis(axisLabel = "x", lowerBound = 0.0, upperBound = 6.0, tickUnit = 0.5),
                                  NumberAxis(axisLabel = "y", lowerBound = 0.0, upperBound = 6.0, tickUnit = 0.5),
                                  buildScatterChartData())

  val statsLabel = new Label:
    id = "stats-label"
    text = "Stats"
    padding = Insets(3)

  val meanLabel = new Label:
    text = "xs mean: " + mean(xs)

  val medianLabel = new Label:
    text = "xs median: " + median(xs)

  val modeLabel = new Label:
    text = "xs mode: " + mode(xs).mkString(", ")

  val rangeLabel = new Label:
    text = "xs range: " + range(xs)

  val histogramLabel = new Label:
    text = "xs histogram: " + histogram(xs).mkString(", ")

  val varianceLabel = new Label:
    text = "xs variance: " + variance(xs)

  val standardDeviationLabel = new Label:
    text = "xs standard deviation: " + standardDeviation(xs)

  val standardErrorLabel = new Label:
    text = "xs standard error: " + standardError(xs)

  val covarianceLabel = new Label:
    text = "xs, ys covariance: " + covariance(xs, ys)

  val correlationCoefficientLabel = new Label:
    text = "xs, ys correlation coefficient: " + correlationCoefficient(xs, ys)

  val centroidLabel = new Label:
    text = "xs, ys centroid: " + centroid(xs, ys)

  val data = new VBox:
    id = "data-pane"
    spacing = 3
    padding = Insets(3)
    children = List(dataLabel, xsLabel, ysLabel, scatterChart)

  val stats = new VBox:
    id = "stats-pane"
    spacing = 3
    padding = Insets(3)
    children = List(
      statsLabel, meanLabel, medianLabel, modeLabel, rangeLabel, histogramLabel, varianceLabel,
      standardDeviationLabel, standardErrorLabel, covarianceLabel, correlationCoefficientLabel,
      centroidLabel
    )

  val dataStatsPane = new HBox:
    spacing = 6
    padding = Insets(6)
    children = List(data, stats)

  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(dataStatsPane)

  val scene = new Scene:
    root = contentPane
    stylesheets = List("/app.css")