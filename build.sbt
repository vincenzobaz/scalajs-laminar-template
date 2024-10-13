name := "Laminar Test"

ThisBuild / scalaVersion := "3.3.4"
version := "0.1-SNAPSHOT"


lazy val frontend = project
  .in(file("frontend"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % "17.1.0",
      "com.raquo" %%% "waypoint" % "8.0.1"
    ),
    //(installJsdom / version) := "2.2.0",
    //(webpack / version) := "5.95.0",
    //(startWebpackDevServer / version) := "5.0.1",
    //Compile / fastOptJS / scalaJSLinkerConfig ~= { _.withSourceMap(false) },
    //Compile / fullOptJS / scalaJSLinkerConfig ~= { _.withSourceMap(true) },
    mainClass := Some("App"),
    scalaJSUseMainModuleInitializer := true,
    //(Test / requireJsDomEnv) := true,
    //useYarn := true
  )

//Compile / npmDependencies += "@material/mwc-slider" -> Versions.MaterialWebComponents
