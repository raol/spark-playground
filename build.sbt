ThisBuild / organization := "io.raol"
ThisBuild / scalaVersion := "2.12.18"

lazy val helloWorld = (project in file("hello-world"))
  .settings(
    name := "hello-world"
  )
