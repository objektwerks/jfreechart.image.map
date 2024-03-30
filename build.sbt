name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.4.1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "21.0.0-R32",
    "org.jfree" % "jfreechart" % "1.5.4"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
