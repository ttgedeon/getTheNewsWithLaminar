package getTheNewsWithLaminar.domain.apiDomain

import getTheNewsWithLaminar.domain.apiDomain.Enumerations.Popularity

case class NewsQuerySettings(keyword: Option[String],
                             searchIn: Option[String],
                             sources: List[String],
                             domains: List[String],
                             excludeDomains: List[String],
                             from: Option[String],
                             to: Option[String],
                             language: Option[String],
                             sortBy: Popularity = Popularity.PUBLISHED_AT,
                             pageSize: Int = 100,
                             page: Int = 1)
