import sbt._
import sbt.Keys._

object ScalaQuizBuild extends Build {

  import Resolvers._
  import Dependencies._

  lazy val root = Project(
    id = "scala-quiz",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-quiz",
      organization := "codingnirvana",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      resolvers := Seq(typesafeRepo),
      libraryDependencies ++= Seq(
        scalatest,
        scalaARM,
        dispatchHttp,
        dispatchJson
      )
    )
  )

  object Resolvers {
    val typesafeRepo = "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
  }

  object Dependencies {
    val scalatest = "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
    val scalaARM = "com.jsuereth" %% "scala-arm" % "1.3"
    val dispatchHttp = "net.databinder.dispatch" % "dispatch-core_2.10" % "0.11.0"
    val dispatchJson = "net.databinder.dispatch" % "dispatch-lift-json_2.10" % "0.11.0"
  }

}
