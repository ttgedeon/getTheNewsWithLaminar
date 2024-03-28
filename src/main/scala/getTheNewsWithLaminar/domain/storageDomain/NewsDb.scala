package getTheNewsWithLaminar.domain.storageDomain


import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.domain.storageDomain.Enumerations.ArticlesUsersTags

import java.util.UUID

object NewsDb:
  val db: Map[UUID, Map[ArticlesUsersTags, List[Article]]] = Map()
