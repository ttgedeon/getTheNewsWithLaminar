package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object SmallArticleCard:
  def apply(): Element =
    div( className := "card mb-3", styleAttr := "max-width: 540px;",
      div(className := "row g-0",
        div(className := "col-md-4",
          img(src := remix, className := "img-fluid rounded-start",
            alt := "JavaScript logo")
        ),
        div(className := "col-md-8",
          div(className := "card-body",
            h5(className := "card-title", "Card title"),
            p(className := "card-text",
              "This is a wider card with supporting"),
            p(className := "card-text",
              small(className := "text-body-secondary",
                "Last updated 3 mins ago")
            )
          )
        )
      )
    )

