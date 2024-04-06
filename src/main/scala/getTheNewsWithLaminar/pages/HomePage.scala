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
  /**
   * Renders the home page
   * @return `ReactiveHtmlElement[HTMLDivElement]`
   */
  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    // user custom  full Article list signal source
    val fullArticleList: Var[Seq[Article]] = Var(Nil)

    // random light article list signal source
    val smallArticleList: Var[Seq[Article]] = Var(Nil)

    /**
     * call the newsAPI and provides articles to
     * @param articleSignalSource article list signal source
     * @return `Unit`
     */
    def articlesProvider(articleSignalSource: Var[Seq[Article]]): Future[Unit] =
      NewsService
        .list
        .map{ (result: ServiceError | NewsResponse) =>
          result match
            case _ : ServiceError =>
              articleSignalSource.update((x: Seq[Article]) => x)
              ()
            case result : NewsResponse =>
              articleSignalSource
                .update((x: Seq[Article]) =>
                  x :++ result.articles.filterNot((_: Article).title == "[Removed]")
                )
              ()
        }

    // providing full articles signal source
    articlesProvider(articleSignalSource = fullArticleList)
    // providing light articles signal source
    articlesProvider(articleSignalSource = smallArticleList)

    /**
     * Converts and articles signal into a signal of card rendered articles
     * @param articlesSignal articles signal
     * @param small rendering size
     * @return `Signal[Seq[Element]]`
     */
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
          children <-- articlesDomElementsStream(articlesSignal=fullArticleList.signal)
        ),
        div(className:="col-12 col-md-3",
          children <-- articlesDomElementsStream(
            articlesSignal=smallArticleList.signal, small=true)
        )
      )
    )