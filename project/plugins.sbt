resolvers += Resolver.url("sbt-plugin-snapshots",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-snapshots/"))(
    Resolver.ivyStylePatterns)

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.3.2")