name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.6.4" // Scala 3.7.1-RC2 breaks ScalaFx!
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "24.0.0-R35",
    "org.jfree" % "jfreechart" % "1.5.5"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
