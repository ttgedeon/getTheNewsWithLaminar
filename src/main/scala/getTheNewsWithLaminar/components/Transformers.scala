package getTheNewsWithLaminar.components

import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.components.MainArticleCard
import com.raquo.laminar.api.L.{*, given}

object Transformers:

  val articleToCard: (Article, Boolean) => Element =
    (article: Article, small: Boolean) =>
      MainArticleCard(
        cardTitle = Some(article.title),
        cardText = Some(article.description),
        imageRef = Some(article.urlToImage),
        date = Some(article.publishedAt),
        smallCard = small
      )

