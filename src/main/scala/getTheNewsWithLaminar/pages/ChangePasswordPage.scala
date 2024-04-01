package getTheNewsWithLaminar.pages

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement
import getTheNewsWithLaminar.components.CustomHtmlAttrs.{ariaLabel, onClicked}

object ChangePasswordPage:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div( className:="row g-0",
      div(
        className :=
          "col-md-6 col-12 vh-100 d-flex justify-content-center align-items-center",
        form(
          idAttr := "singUpForm",
          className := "bg-light shadow p-4 rounded row g-3 needs-validation h-auto " +
            "form-width",
          noValidate:=true,
          img(
            src :=
              "https://i.pinimg.com/736x/0f/51/43/0f514348930957803d557f6f825aa36b.jpg",
            className := "m-auto newsLogo"),

          div(
            className:="col-12",
            label(
              forId:="oldPassword", className:="form-label",
              span(className:="text-danger", "*"),
              "Old password"
            ),
            input(
              idAttr:="oldPassword", `type`:="password", className:="form-control",
              placeholder :="Old password", ariaLabel:="Old assword",
              required := true
            ),
            div(
              className:="invalid-feedback",
              "Please enter your old password."
            )
          ),
          div(
            className:="col-12",
            label(
              forId:="newPassword", className:="form-label",
              span(className:="text-danger",  "*"),
              "New password"
            ),
            input(
              forId:="newPassword", `type`:="password", className:="form-control",
              placeholder := "New password", ariaLabel:="Confirm password",
              required := true
            ),
            div(
              className:="invalid-feedback",
              "Please enter your new password"
            )
          ),
          div(
            className:="col-12",
            button(
              className:="btn btn-primary", `type`:="submit",
              onClicked :="validate",
              "Submit form"
            )
          )
        ) // form
      ),
      div(
        className:="col-0 col-md-6 vh-100",
        img(
          className:="h-100 w-100",
          styleAttr:="object-fit: cover; object-position: center",
          src:="https://i.pinimg.com/564x/2a/21/3c/2a213c3db529ca7ca41aebc4ce48dabe.jpg"
        )
      )
    )
