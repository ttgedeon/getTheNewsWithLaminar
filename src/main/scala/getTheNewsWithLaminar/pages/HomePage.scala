package getTheNewsWithLaminar.pages

import getTheNewsWithLaminar.components.*
import getTheNewsWithLaminar.services.apiServices.NewsService
import getTheNewsWithLaminar.repositories.apiRepository.NewsRepository
import getTheNewsWithLaminar.domain.apiDomain.{NewsResponse, Article}
import getTheNewsWithLaminar.services.generics.ServiceError

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
    val fullArticleList: Var[Seq[Article]] = Var(Nil)

    val smallArticleList: Var[Seq[Article]] = Var(Nil)

    val fullArticlesSignal: StrictSignal[Seq[Article]] = fullArticleList.signal

    val smallArticlesSignal: StrictSignal[Seq[Article]] = smallArticleList.signal

    def apiResponse(articleStream: Var[Seq[Article]]): Future[Unit] =
      NewsService
        .list
        .map{ (result: ServiceError | NewsResponse) =>
          result match
            case _ : ServiceError =>
              articleStream.update((x: Seq[Article]) => x)
              ()
            case result : NewsResponse =>
              articleStream
                .update((x: Seq[Article]) =>
                  x :++ result.articles.filterNot((_: Article).title == "[Removed]")
                )
              ()
        }

    apiResponse(articleStream = fullArticleList)
    apiResponse(articleStream = smallArticleList)

    def articlesDomElementsStream(articlesSignal: StrictSignal[Seq[Article]],
                                  small: Boolean=false): Signal[Seq[Element]] =
      articlesSignal
        .split((_: Article).url) {
        (_: String, initial: Article, articleSignal: Signal[Article])  =>
          MainArticleCard(
            imgSrc=initial.urlToImage, articleSignal=articleSignal, smallCard = small
          )
      }

    div(
      NavBarSecond(),
      div(className:="row g-4",
        div(className:="col-12",
          UserCategories(
            "FootBall", "Health", "Economy", "Politics"
          )
        ),
        div(className:="col-12 col-md-9",
          children <-- articlesDomElementsStream(articlesSignal=fullArticlesSignal)
        ),
        div(className:="col-12 col-md-3",
          children <-- articlesDomElementsStream(
            articlesSignal=smallArticlesSignal, small=true)
        )
      )
    )