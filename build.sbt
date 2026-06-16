name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.9.0-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "26.0.0-R38",
    "org.jfree" % "jfreechart" % "1.5.6"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
