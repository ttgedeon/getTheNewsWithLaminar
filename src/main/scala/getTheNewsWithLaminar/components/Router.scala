package getTheNewsWithLaminar.components

import getTheNewsWithLaminar.pages.*

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import frontroute.*

object Router:
  def apply(): Element =
    mainTag(
      routes(
        div(
          cls := "container-fluid",
          (pathEnd | path("home")) {
           div(
             NavBar.apply(),
             HomePage()
           )
          },
          path("login") {
            LoginPage()
          },
          path("signup") {
            SignupPage()
          },
          path("changePassword") {
            ChangePasswordPage()
          },
          noneMatched {
            NotFoundPage()
          }
        )
      )
    )
