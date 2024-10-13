import com.raquo.laminar.api.L._
import org.scalajs.dom

@main
def main(): Unit =
  val containerNode = dom.document.querySelector("#app")
  render(containerNode, interactive())

def interactive() =
  val nameVar = Var(initial = "world")
  div(
    label("Your name: "),
    input(
      onMountFocus,
      placeholder := "Enter your name here",
      onInput.mapToValue --> nameVar
    ),
    br(),
    span(
      "Hello, ",
      child.text <-- nameVar.signal.map(_.toUpperCase)
    )
  )
