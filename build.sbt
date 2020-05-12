ThisBuild / scalaVersion := "2.13.2"

lazy val nested = (project in file("nested"))
  .settings(
    name := "nested",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test
  )