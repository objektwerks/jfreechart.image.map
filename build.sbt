name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.4.2"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "22.0.0-R33",
    "org.jfree" % "jfreechart" % "1.5.4"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
