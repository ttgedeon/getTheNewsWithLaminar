package getTheNewsWithLaminar.pages

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement
import getTheNewsWithLaminar.components.NavBarSecond

object NotFoundPage:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div(
      NavBarSecond(),
      "Page not found"
    )
