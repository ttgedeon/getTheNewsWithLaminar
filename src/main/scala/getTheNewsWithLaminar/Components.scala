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

  val simpleControlInput: Element = formControlInput(
    divClass = "form-floating",
    inputType = "text",
    inputClass = "form-control",
    inputId = "repo",
    inputPlaceholder = "Comment id",
    forLabel = "Comment id",
    labelContent = "idComment"
  )

  val infoButton: Element = buttonInfo(
    buttonType = "button", buttonClass = "btn btn-info",
    buttonContent = "Info"
  )

  val infoButtonX: Element = buttonInfoX(
    buttonType = "button", buttonClass = "btn btn-info",
    buttonContent = "InfoXXX"
  )

  val primaryCard: Element =
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
    customStringCompositeHtmlAttr("aria-expanded", separator = " ")

  val ariaLabel: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-label", separator = " ")

  val ariaCurrent: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-current", separator = " ")

  val ariaDisabled: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-disabled", separator = " ")

  val mainNavBar: Element =
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

  val secondaryCard:
    (Option[String], Option[String], Option[String], Option[String],
      Option[String]) => Element =
      (cardTitle: Option[String], cardText: Option[String],
       imageRef: Option[String], date: Option[String], pictureAlt: Option[String]
      ) =>

      div(className := "card mb-3", styleAttr := "max-width: 540px;",
        div(className := "row g-0",
          div(className := "col-md-4",
            img(src := imageRef.getOrElse(remix), className := "img-fluid rounded-start",
              alt := pictureAlt.getOrElse("The JVS img"))
          ),
          div(className := "col-md-8",
            div(className := "card-body",
              h5(className := "card-title",
                child.text <-- Var(cardTitle.getOrElse("Card title")).signal),
              p(className := "card-text",
                child.text <-- Var(cardText.getOrElse("This is a wider card with supporting text below " +
                  "as a natural lead-in to additional content. This content is a " +
                  "little bit longer."))
              ),
              p(className := "card-text",
                small(className := "text-body-secondary",
                  child.text <-- Var(s"Last updated ${date.getOrElse("3 mins")} ago")
                )
              )
            )
          )
        )
      )

  val forAttr: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("for", separator = " ")

  val formCheckBox : (Option[String],  Option[Boolean]) => Element =
    (title: Option[String], checkStatus: Option[Boolean]) =>

    div(className := "form-check",
      input(className := "form-check-input", `type` := "checkbox",
        idAttr := "flexCheckChecked", checked := checkStatus.getOrElse(false)
      ),
      label(className := "form-check-label", forAttr := "flexCheckChecked",
        child.text <-- Var(title.getOrElse("Checked checkbox")).signal
      )
    )

  val dataToogle: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-toggle", separator = " ")

  val dataTarget: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-target", separator = " ")

  val ariaLabelledBy: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-labelledby", separator = " ")


  val secondaryNavBar: (Option[String], Option[String], Option[String],
    Option[String], Option[String], Option[String], Option[String], Option[String]) => Element =
    (elt1: Option[String], elt2: Option[String], elt3: Option[String],
     elt4: Option[String], elt5: Option[String], elt6: Option[String],
     elt7: Option[String], elt8: Option[String]) =>
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