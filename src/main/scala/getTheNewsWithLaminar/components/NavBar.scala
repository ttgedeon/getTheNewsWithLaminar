package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import CustomHtmlAttrs.*

object NavBar:
  def apply(): Element =
    navTag(className := "navbar navbar-expand-lg bg-body-tertiary",
      div(className := "container-fluid",
        button(className := "navbar-toggler", `type` := "button",
          dataBsToggle := "collapse", dataBsTarget := "#navbarTogglerDemo03",
          ariaControls := "navbarTogglerDemo03", ariaExpanded := "false",
          ariaLabel := "Toggle navigation",
          child <-- Var(span(className := "navbar-toggler-icon")).signal
        ),
        a(className := "navbar-brand", href := "#", child.text <-- Var("Navbar").signal),
        div(className := "collapse navbar-collapse", idAttr := "navbarTogglerDemo03",
          ul(className := "navbar-nav me-auto mb-2 mb-lg-0",
            li(className := "nav-item",
              a(className := "nav-link active", ariaCurrent := "page",
                href := "#", child.text <-- Var("Home").signal)
            ),
            li(className := "nav-item",
              a(className := "nav-link disabled", href := "#", ariaDisabled := "true",
                child.text <-- Var("Link").signal)
            ),
            li(className := "nav-item",
              a(className := "nav-link disabled", ariaDisabled := "true",
                child.text <-- Var("Disabled").signal)
            )
          ),
          form(className := "d-flex", role := "search",
            input(className := "form-control me-2", `type` := "search",
              placeholder := "Search", ariaLabel := "Search"
            ),
            button(className := "btn btn-outline-success", `type` := "submit",
              child.text <-- Var("Search").signal)
          )
        )
      )
    )
