name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.9.0"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "27.0.0-R39",
    "org.jfree" % "jfreechart" % "1.5.6"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
