import play.Project._

organization := "com.clever-age"

name := "play2-elasticsearch"

version := "0.8-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  javaCore,
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.2",
  "org.elasticsearch" % "elasticsearch" % "0.90.3",
  "org.apache.commons" % "commons-lang3" % "3.1"
)

resolvers ++= Seq(
    Resolver.typesafeRepo("releases"),
    "oss sonytape (release)" at "http://oss.sonatype.org/content/repositories/releases/"
)

publishMavenStyle := false

publishTo <<= (version) { v: String =>
    val status = if(v.trim.endsWith("-SNAPSHOT")) "snapshots" else "releases"
    Some(Resolver.sbtPluginRepo(status))
}

playScalaSettings
