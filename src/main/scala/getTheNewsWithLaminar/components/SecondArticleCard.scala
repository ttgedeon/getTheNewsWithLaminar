package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object SecondArticleCard:
  def apply(): Element =
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

