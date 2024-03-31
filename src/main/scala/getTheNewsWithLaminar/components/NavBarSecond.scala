package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*

object NavBarSecond:
  def apply(elt1: Option[String], elt2: Option[String], elt3: Option[String],
            elt4: Option[String], elt5: Option[String], elt6: Option[String],
            elt7: Option[String], elt8: Option[String]): Element =

    navTag(className := "navbar navbar-expand-lg navbar-light bg-light",
      div(className := "container-fluid",
        a(className := "navbar-brand", href := "#",
          child.text <-- Var(elt1.getOrElse("Navbar scroll")).signal),
        button(className := "navbar-toggler", `type` := "button",
          dataBsToggle := "collapse", dataBsTarget := "#navbarScroll",
          ariaControls := "navbarScroll", ariaExpanded := "false",
          ariaLabel := "Toggle navigation",
          span(className := "navbar-toggler-icon")
        ),
        div(className := "collapse navbar-collapse", idAttr := "navbarScroll",
          ul(className := "navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll",
            styleAttr := "--bs-scroll-height: 100px;",
            li(className := "nav-item",
              a(className := "nav-link active", ariaCurrent := "page", href := "#",
                child.text <-- Var(elt2.getOrElse("Home")).signal
              ),
            ),
            li(className := "nav-item",
              a( className := "nav-link", href := "#",
                child.text <-- Var(elt3.getOrElse("Link")).signal)
            ),
            li(className := "nav-item dropdown",
              a(className := "nav-link dropdown-toggle", href := "#",
                idAttr := "navbarScrollingDropdown", role := "button",
                dataBsToggle := "dropdown", ariaExpanded := "false",
                child.text <-- Var(elt4.getOrElse("Link")).signal
              ),
              ul(className := "dropdown-menu",
                ariaLabelledBy := "navbarScrollingDropdown",
                li(a(className := "dropdown-item", href := "#",
                  child.text <-- Var(elt5.getOrElse("Action")).signal)
                ),
                li(a(className := "dropdown-item", href := "#",
                  child.text <-- Var(elt6.getOrElse("Another action")).signal)
                ),
                li(hr(className := "dropdown-divider")
                ),
                li(a(className := "dropdown-item", href := "#",
                  child.text <-- Var(elt7.getOrElse("Something else here")).signal)
                )
              )
            ),
            li(className := "nav-item",
              a(className := "nav-link disabled",
                child.text <-- Var(elt7.getOrElse("Link")).signal)
            )
          ),
          form(className := "d-flex",
            input(className := "form-control me-2", `type` := "seach",
              placeholder := "Search", ariaLabel := "Search"
            ),
            button(className := "btn btn-outline-success", `type` := "submit",
              child.text <-- Var(elt8.getOrElse("Search")).signal
            )
          )
        )
      )

    )