package getTheNewsWithLaminar.pages

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement

object NotFoundPage:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div("Page not found")
