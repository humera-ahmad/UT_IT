name := "UT_IT"

version := "0.1"

scalaVersion := "2.13.4"

lazy val question1_2 = (project in file("question1_2")).settings(
  libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.3" % Test,
  "org.mockito" %% "mockito-scala" % "1.5.12" % Test
  )
)


lazy val question3 = (project in file("question3")).settings(
  libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.3" % Test,
  "org.mockito" %% "mockito-scala" % "1.5.12" % Test
  )
)

lazy val UT_IT = (project in file(".")).aggregate(question1_2, question3)