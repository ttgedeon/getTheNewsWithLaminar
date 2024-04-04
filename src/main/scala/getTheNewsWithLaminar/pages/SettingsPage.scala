package getTheNewsWithLaminar.pages

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement
import getTheNewsWithLaminar.components.CustomHtmlAttrs.{ariaLabel, onClicked}
import getTheNewsWithLaminar.components.NavBarSecond


object SettingsPage:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div(
      NavBarSecond(),
      "SettingsPage"
    )

