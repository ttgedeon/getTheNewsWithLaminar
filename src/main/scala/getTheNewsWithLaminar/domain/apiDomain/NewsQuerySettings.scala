package getTheNewsWithLaminar.domain.apiDomain

import getTheNewsWithLaminar.domain.apiDomain.Enumerations.{
  Languages,
  ArticleSortCriteria,
  SearchInFields
}

/**
  * Api Request parameters settings
  * @param keyword Keywords or phrases to search for in the article title and
  *                body
  * @param searchIn The fields to restrict your q search to
  * @param sources A comma-separated string of identifiers (maximum 20) for the
  *                news sources or blogs you want headlines from.
  * @param domains A comma-seperated string of domains (eg bbc.co.uk,
  *                techcrunch.com, engadget.com) to restrict the search to.
  * @param excludeDomains A comma-seperated string of domains (eg bbc.co.uk,
  *                       techcrunch.com, engadget.com) to remove from the
  *                       results.
  * @param from A date and optional time for the oldest article allowed. This
  *             should be in ISO 8601 format (e.g. 2024-03-28 or 2024-03-28T09:29:01)
  * @param to A date and optional time for the newest article allowed.
  *           This should be in ISO 8601 format (e.g. 2024-03-28 or 2024-03-28T09:29:01)
  * @param language The 2-letter ISO-639-1 code of the language you want to get
  *                 headlines for. Possible options:
  * @param sortBy The order to sort the articles in. Possible options: relevancy, popularity, publishedAt.
  *               relevancy = articles more closely related to q come first.
  *               popularity = articles from popular sources and publishers come first.
  *               publishedAt = newest articles come first.
  * @param pageSize The number of results to return per page.
  * @param page Use this to page through the results
  */
case class NewsQuerySettings(keyword: Option[String],
                             searchIn: Option[Set[SearchInFields]],
                             sources: Set[String],
                             domains: Set[String],
                             excludeDomains: Set[String],
                             from: Option[String],
                             to: Option[String],
                             language: Option[Languages],
                             sortBy: ArticleSortCriteria =
                               ArticleSortCriteria.PUBLISHED_AT,
                             pageSize: Int = 100,
                             page: Int = 1)
