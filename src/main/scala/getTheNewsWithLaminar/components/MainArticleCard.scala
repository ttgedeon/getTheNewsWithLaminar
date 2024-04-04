package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*
import getTheNewsWithLaminar.domain.apiDomain.Article


object MainArticleCard:
  def apply(imgSrc: String, articleSignal: Signal[Article], smallCard: Boolean = false)
  : Element =

    def dynamicBodyClass: String = if !smallCard then "col-md-8"  else ""
    def dynamicHeight: String = if !smallCard then "cardHeight" else ""
    def dynamicFondSize: String = if !smallCard then " fs-1" else ""

    div(className := "card mb-3 w-100 " + dynamicHeight,
      div(className := "row g-0 h-100 flex-md-row-reverse",
        div(className := "col-md-4 cardImageHeight",
          img(src := imgSrc,
            className := "rounded-start w-100 h-100 objectFit",
            alt := "Article image"
          )
        ),
        div(className := dynamicBodyClass,
          div(className := "card-body",
            h2(className := "card-title fw-bold" + dynamicFondSize,
              child.text <-- articleSignal.map((_: Article).title)),
            div(p(className := "card-text d-none d-md-block",
              child.text <-- articleSignal.map((_: Article).title)
            )),
            p(className := "card-text",
              small(className := "text-body-secondary",
                "Published at: ",
                child.text <-- articleSignal.map((_: Article).publishedAt)
              )
            )
          )
        )
      )
    )
