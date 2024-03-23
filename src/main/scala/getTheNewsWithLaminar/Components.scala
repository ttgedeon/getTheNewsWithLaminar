package getTheNewsWithLaminar

import com.raquo.laminar.api.L.{*, given}
import ComponentsFactory.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/remix.png", JSImport.Default)
val remix: String = js.native

object Components:

  val passwordControlInput: Element = formControlInput(
    divClass = "form-floating",
    inputType = "password",
    inputClass = "form-control",
    inputId = "floatingPassword",
    inputPlaceholder = "Password",
    forLabel = "floatingPassword",
    labelContent = "Password"
  )

  val infoButton: Element = buttonInfo(
    buttonType = "button", buttonClass = "btn btn-info",
    buttonContent = "Info"
  )

  val mainCard: Element =
    div( className := "card mb-3", styleAttr := "max-width: 540px;",
      div(className := "row g-0",
        div(className := "col-md-4",
          img(src := remix, className := "img-fluid rounded-start",
            alt := "JavaScript logo")
        ),
        div(className := "col-md-8",
          div(className := "card-body",
            h5(className := "card-title", child.text <-- Var("Card title").signal),
            p(className := "card-text",
              child.text <-- Var("This is a wider card with supporting").signal),
            p(className := "card-text",
              small(className := "text-body-secondary",
                child.text <-- Var("Last updated 3 mins ago"))
            )
          )
        )
      )
    )

  val dataBsToggle : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-bs-toggle", separator = " ")

  val dataBsTarget : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-bs-target", separator = " ")

  val ariaControls : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-controls", separator = " ")

  val ariaExpanded: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-controls", separator = " ")

  val arialLabel: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-label", separator = " ")

  val arialCurrent: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-current", separator = " ")

  val arialDisabled: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-disabled", separator = " ")

  val mainNavBar: Element =
    navTag(className := "navbar navbar-expand-lg bg-body-tertiary",
      div(className := "container-fluid",
        button(className := "navbar-toggler", `type` := "button",
          dataBsToggle := "collapse", dataBsTarget := "#navbarTogglerDemo03",
          ariaControls := "navbarTogglerDemo03", ariaExpanded := "false",
          arialLabel := "Toggle navigation",
          span(className := "navbar-toggler-icon")
        ),
        a(className := "navbar-brand", href := "#", child.text <-- Var("Navbar").signal),
        div(className := "collapse navbar-collapse", idAttr := "navbarTogglerDemo03",
          ul(className := "navbar-nav me-auto mb-2 mb-lg-0",
            li(className := "nav-item",
              a(className := "nav-link active", arialCurrent := "page",
                href := "#", child.text <-- Var("Home"))
            ),
            li(className := "nav-item",
              a(className := "nav-link disabled", href := "#", arialDisabled := "true",
                child.text <-- Var("Link"))
            ),
            li(className := "nav-item",
              a(className := "nav-link disabled", arialDisabled := "true",
                child.text <-- Var("Disabled"))
            )
          ),
          form(className := "d-flex", role := "search",
            input(className := "form-control me-2", `type` := "search",
              placeholder := "Search", arialLabel := "Search"
            ),
            button(className := "btn btn-outline-success", `type` := "submit",
              child.text <-- Var("Search"))
          )
        )
      )
    )
