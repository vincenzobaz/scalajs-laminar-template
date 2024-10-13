
# Laminar App Template

Template for a Scala.js frontend application using [Laminar](https://laminar.dev/)
and [ScalablyTyped](https://scalablytyped.org/) to use TypeScript typings.

## Background

I had a cool idea for a webapp. I sketched it out,
thought about the tech stack, the UX.
I decided to use Scala for the fronted using Scala 3, Scala.js and Laminar.
Excited, I set in front of the keyboard... **Just to spend
hours putting together the build** and understanding all of the pieces.

I did not invent anything, I followed these excellent documentation
pages

 - [Getting Started with Scala.js and Vite]https://www.scala-js.org/doc/tutorial/scalajs-vite.html
 - ScalablyTyped [SBT plugin without scalajs-bundler](https://scalablytyped.org/docs/plugin-no-bundler)

I decided to set up a minimalistic template and make it public
for other people having the same ideas.

## Development mode

 - Inside an sbt shell, run `~frontend/fastLinkJS`.
 - In another terminal `cd frontend` and then `npm run dev`.
 - Open the link appearing in the terminal in your browser.
 - Any change to the Scala code will trigger a refresh of the app in your browser

You can run `scalafmtAll` to format the codebase.

You can add Javascript/Typescript dependencies with
`npm install --save <lib>` inside the `frontend` directory.

## Ingredients

 - sbt
 - vite
 - scalajs
 - laminar
 - ScalablyTyped

## Tooling

 - scalafmt
 - nix shell
 - sbt-tpolecat
