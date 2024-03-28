import org.scalajs.linker.interface.ModuleSplitStyle

resolvers += "Typesafe Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

val circeVersion = "0.14.5"

lazy val getTheNewsWithLaminar = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    scalaVersion := "3.3.1",
    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,
    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "livechart" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("getTheNewsWithLaminar"))
        )
    },
    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0",
    // Depend on Laminar
    libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",
    // Depend on Circe
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core",
      "io.circe" %%% "circe-parser",
      "io.circe" %%% "circe-generic"
    ).map(_.%(revision = circeVersion)),
    libraryDependencies += "org.http4s" %%% "http4s-dom" % "0.2.11",
    libraryDependencies += "org.http4s" %%% "http4s-circe" % "0.23.25",
    libraryDependencies += "io.circe" %%% "circe-literal" % "0.14.6",
    // recommended, brings in the latest client module
    libraryDependencies += "org.http4s" %%% "http4s-client" % "0.23.25",
    libraryDependencies += "org.http4s" %% "http4s-dsl" % "0.23.25",
    libraryDependencies += "com.softwaremill.sttp.client4" %%% "core" % "4.0.0-M1",
    libraryDependencies += "com.lihaoyi" %%% "upickle" % "3.2.0",
    libraryDependencies += "eu.timepit" %%% "refined" % "0.11.1",
    // Tell ScalablyTyped that we manage `npm install` ourselves
    externalNpm := baseDirectory.value,
  )
