package getTheNewsWithLaminar.pages

import getTheNewsWithLaminar.components.*
import getTheNewsWithLaminar.services.apiServices.NewsService
import getTheNewsWithLaminar.repositories.apiRepository.NewsRepository
import getTheNewsWithLaminar.domain.apiDomain.{NewsResponse, Article}
import getTheNewsWithLaminar.services.generics.ServiceError
import getTheNewsWithLaminar.components.Transformers.articleToCard

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement
import org.scalajs.dom.UIEvent
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object HomePage:
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    val fullArticleList: Var[Seq[Element]] = Var(Nil)
    val smallArticleList: Var[Seq[Element]] = Var(Nil)

    val fullArticlesSignal: StrictSignal[Seq[Element]] = fullArticleList.signal
    val smallArticlesSignal: StrictSignal[Seq[Element]] = smallArticleList.signal

    def apiResponse(articleStream: Var[Seq[Element]] , small: Boolean = false): Future[Unit] =
      NewsService
        .listResponse
        .map{ (result: ServiceError | NewsResponse) =>
          result match
            case _ : ServiceError =>
              articleStream.update((x: Seq[Element]) => x)
              ()
            case result : NewsResponse =>
              val articles: Seq[Element] =
                result.articles.map(articleToCard(_: Article, small))
              articleStream.update((x: Seq[Element]) => x :++ articles)
              ()
        }

    apiResponse(articleStream = fullArticleList)
    apiResponse(articleStream = smallArticleList, small = true)

    div(
      NavBarSecond(),
      div(className:="row g-4",
        div(className:="col-12",
          UserCategories(
            "FootBall", "Health", "Economy", "Politics"
          )
        ),
        div(className:="col-12 col-md-9",
          children <-- fullArticlesSignal
        ),
        div(className:="col-12 col-md-3",
          children <-- smallArticlesSignal
        )
      )
    )