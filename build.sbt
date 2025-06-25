name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.7.2-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "24.0.0-R35",
    "org.jfree" % "jfreechart" % "1.5.5"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all",
  // Silences 3.7.0+ implicit using warnings:
  "-Wconf:msg=Implicit parameters should be provided with a `using` clause:s"
)
