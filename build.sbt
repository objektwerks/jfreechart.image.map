name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.8.3-RC3"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "26.0.0-R38",
    "org.jfree" % "jfreechart" % "1.5.6"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
