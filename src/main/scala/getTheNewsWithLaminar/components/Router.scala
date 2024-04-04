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
            HomePage()
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
          path("resetPassword") {
            ResetPasswordPage()
          },
          path("savedNews") {
            SavedNews()
          },
          path("likedNews") {
            LikedNewsPage()
          },
          path("history") {
            HistoryPage()
          },
          path("dashboard") {
            DashboardPage()
          },
          path("settings") {
            SettingsPage()
          },
          path("profile") {
            ProfilePage()
          },
          path("logout"){
            LogoutPage()
          },
          noneMatched {
            NotFoundPage()
          }
        )
      )
    )
