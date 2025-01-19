name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.6.3"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "23.0.1-R34",
    "org.jfree" % "jfreechart" % "1.5.5"
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
