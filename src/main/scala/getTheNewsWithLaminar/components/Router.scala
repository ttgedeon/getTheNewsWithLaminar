package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import frontroute.*

object Router:
  def apply(): Element =
    mainTag(
      routes(
        div(
          cls := "container-fluid",
          pathEnd {
           div(NavBar.apply())
          },
          path("home") {
            div("The home page")
          }
        )
      )
    )
