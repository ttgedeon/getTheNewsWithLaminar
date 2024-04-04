package getTheNewsWithLaminar.pages

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement
import getTheNewsWithLaminar.components.NavBarSecond
import getTheNewsWithLaminar.components.CustomHtmlAttrs.{ariaLabel, onClicked}

object SavedNews:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div(
      NavBarSecond(),
      "Saved news"
    )
