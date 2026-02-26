name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.8.2"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "25.0.2-R37",
    "org.jfree" % "jfreechart" % "1.5.6"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
