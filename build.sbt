name := "jfreechart.image.map"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.4.0-RC4"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "21.0.0-R32",
    "org.jfree" % "jfreechart" % "1.5.4",
    "ch.qos.logback" % "logback-classic" % "1.4.14"
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)