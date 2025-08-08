name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.7.3-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "24.0.2-R36",
    "org.jfree" % "jfreechart" % "1.5.5"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
