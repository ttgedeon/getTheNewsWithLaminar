package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.MouseEvent
import getTheNewsWithLaminar.components.CustomHtmlAttrs.*

object UserCategories:
  def apply(categories: String*): Element =

    val categoryItems: Seq[Element] = categories.map{ (category: String) =>
      li( className:="nave-item",
        span(
          className:="nav-link",
          ariaCurrent := "page", href:="#", category,
          onClick --> {(_: MouseEvent) =>
            println(s"The category $category has been selected ")
          }
        )
      )
    }

    ul( className:="nav nav-pills",
      children <-- Var[Seq[Element]](categoryItems).signal
    )





