name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.6.2-RC3"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "23.0.1-R34",
    "org.jfree" % "jfreechart" % "1.5.4"
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
