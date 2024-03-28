package getTheNewsWithLaminar.domain.storageDomain


import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.domain.storageDomain.Enumerations.ArticlesUsersTags

object NewsDb:
  val db: Map[String, Map[ArticlesUsersTags, List[Article]]] = Map()
