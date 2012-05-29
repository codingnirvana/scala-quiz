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
      scalaVersion := "2.9.2",
      resolvers := Seq(typesafeRepo),
      libraryDependencies ++= Seq(
        scalatest
      )
    )
  )

  object Resolvers {
    val typesafeRepo = "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
  }

  object Dependencies {
    val scalatest = "org.scalatest" %% "scalatest" % "1.6.1" % "test"
  }

}
