name := "game1"

version := "0.1"

scalaVersion := "2.12.6"


// for cats library
libraryDependencies +=
  "org.typelevel" %% "cats-core" % "1.0.0"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification"
)

scalacOptions ++= Seq("-feature")


// for swing
///libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10+"
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2"