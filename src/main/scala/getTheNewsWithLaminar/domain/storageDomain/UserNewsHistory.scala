package getTheNewsWithLaminar.domain.storageDomain

import java.util.UUID
import getTheNewsWithLaminar.domain.apiDomain.Article
import Enumerations.ArticlesUsersTags

case class UserNewsHistory(userId: UUID,
                           articles: Map[ArticlesUsersTags, List[Article]])
