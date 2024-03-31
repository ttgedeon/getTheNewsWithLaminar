package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object MainArticleCard:
  def apply(cardTitle: Option[String], cardText: Option[String],
            imageRef: Option[String], date: Option[String], pictureAlt: Option[String]
           ): Element =
    div(className := "card mb-3", styleAttr := "max-width: 540px;",
      div(className := "row g-0",
        div(className := "col-md-4",
          img(src := imageRef.getOrElse(remix), className := "img-fluid rounded-start",
            alt := pictureAlt.getOrElse("The JVS img"))
        ),
        div(className := "col-md-8",
          div(className := "card-body",
            h5(className := "card-title",
              cardTitle.getOrElse("Card title")),
            p(className := "card-text",
              cardText.getOrElse("This is a wider card with supporting text below " +
                "as a natural lead-in to additional content. This content is a " +
                "little bit longer.")
            ),
            p(className := "card-text",
              small(className := "text-body-secondary",
                s"Last updated ${date.getOrElse("3 mins")} ago"
              )
            )
          )
        )
      )
    )
