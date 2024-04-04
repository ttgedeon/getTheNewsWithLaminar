package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object MainArticleCard:
  def apply(cardTitle: Option[String]=None, cardText: Option[String]=None,
            imageRef: Option[String]=None, date: Option[String]=None,
            pictureAlt: Option[String]=None,
           smallCard: Boolean = false): Element =

//    def conditionalImage: Element = if imageRef.nonEmpty & !smallCard then
    def conditionalImage: Element = if imageRef.nonEmpty then
      div(className := "col-md-4 cardImageHeight",
      img(src := imageRef.getOrElse(remix),
        className := "rounded-start w-100 h-100 objectFit",
        alt := pictureAlt.getOrElse("There is no image")
      )
    )
    else
      div()


    def dynamicBodyClass: String = if imageRef.nonEmpty then "col-md-8"  else ""

    def cardContent: Element =
      if !smallCard then
        div(p(className := "card-text d-none d-md-block",
          cardText.getOrElse("Nothing to display")
        ))
      else
        div()

    def dynamicHeight: String = if !smallCard then "cardHeight" else ""
    def dynamicFondSize: String = if !smallCard then " fs-1" else ""
    def dynamicTitle: Element =
      if !smallCard then
        h2(className := "card-title fw-bold" + dynamicFondSize,
          cardTitle.getOrElse("Nothing to display"))
      else
        h5(className := "card-title fw-bold" + dynamicFondSize,
          cardTitle.getOrElse("Nothing to display"))

    div(className := "card mb-3 w-100 " + dynamicHeight,
      div(className := "row g-0 h-100 flex-md-row-reverse",
        conditionalImage
        ,
        div(className := dynamicBodyClass,
          div(className := "card-body",
            dynamicTitle,
            cardContent,
            p(className := "card-text",
              small(className := "text-body-secondary",
                s"Last updated ${date.getOrElse("")} ago"
              )
            )
          )
        )
      )
    )
