import org.typelevel.scalacoptions.ScalacOptions
import org.scalajs.linker.interface.ModuleSplitStyle
import scala.sys.process.Process

name := "Laminar Template"

ThisBuild / scalaVersion := "3.3.4"

lazy val frontend = project
  .in(file("frontend"))
  .enablePlugins(
    // Enable Scala JS
    ScalaJSPlugin,
    // Enable compilation of Typscript typings to Scala
    ScalablyTypedConverterExternalNpmPlugin
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % "17.1.0",
      "com.raquo" %%% "waypoint" % "8.0.1",
      "org.scala-js" %%% "scalajs-dom" % "2.8.0"
    ),
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
          ModuleSplitStyle.SmallModulesFor(List("frontend"))
        )
    },

    // Disable this warning or main does not compile
    Compile / tpolecatExcludeOptions += ScalacOptions.warnValueDiscard,

    // Tell ScalablyTyped that to use npm
    externalNpm := {
      Process("npm", baseDirectory.value).!
      baseDirectory.value
    },
    Test / requireJsDomEnv := true
  )
