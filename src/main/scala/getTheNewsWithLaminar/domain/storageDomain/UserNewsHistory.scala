package getTheNewsWithLaminar.domain.storageDomain

import java.util.UUID
import getTheNewsWithLaminar.domain.apiDomain.Article
import Enumerations.ArticlesUsersTags

case class StoredArticles(userId: UUID,
                          articles: Map[ArticlesUsersTags, List[Article]],
)
