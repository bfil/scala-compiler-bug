lazy val root = Project("root", file("."))
  .settings(scalaVersion in ThisBuild := "2.12.1")
  .settings(crossScalaVersions := Seq("2.11.8", "2.12.1"))
  .aggregate(generatorMacros, generator)

lazy val generatorMacros = Project("generator-macros", file("generator-macros"))
  .settings(libraryDependencies ++= scalaReflect(scalaVersion.value))

lazy val generator = Project("generator", file("generator"))
  .settings(libraryDependencies ++= specs2)
  .dependsOn(generatorMacros)

def scalaReflect(scalaVersion: String) = Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion
)

lazy val specs2 = Seq(
  "org.specs2" %% "specs2-core" % "3.8.6" % "test"
)
