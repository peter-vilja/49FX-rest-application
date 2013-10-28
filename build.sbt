organization := "fi.peter"

name := "49FX-rest-application"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

crossPaths := false

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.2.1",
  "org.scalatra" %% "scalatra-specs2" % "2.2.1" % "test",
  "org.scalatra" %% "scalatra-json" % "2.2.1",
  "org.json4s" %% "json4s-jackson" % "3.1.0",
  "commons-codec" % "commons-codec" % "1.6",
  "joda-time" % "joda-time" % "2.1",
  "org.joda" % "joda-convert" % "1.2",
  "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
  "org.slf4j" % "slf4j-api" % "1.6.4",
  "org.mockito" % "mockito-all" % "1.8.5" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.mongodb" %% "casbah" % "2.6.2"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "oss.sonatype.org" at "https://oss.sonatype.org/content/groups/scala-tools/"

testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Spec")))

scalacOptions ++= Seq("-unchecked", "-deprecation")