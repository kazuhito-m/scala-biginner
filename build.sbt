organization := "hm.orz.sumpic"

name := "scala-biginner"

version := "0.0.1"

scalaVersion := "2.11.1"

publishTo := Some(Resolver.file("scala-bibinner",file("./target/repo"))(Patterns(true, Resolver.mavenStyleBasePattern)))

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.1-M3" % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

