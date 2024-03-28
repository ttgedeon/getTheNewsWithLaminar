package getTheNewsWithLaminar.domain.apiDomain

import getTheNewsWithLaminar.domain.apiDomain.Enumerations.{Category, Country}

/**
  * This class models the headlines API query settings for a user
  * @param country The 2-letter ISO 3166-1 code of the country you want to get
  *                headlines for. Possible options
  * @param category The category we want to get headlines for. Possible
  *                 options: business, entertainment, general, health, sciences,
  *                 ports, technology. Note: you can't mix this param with the
  *                 sources param
  * @param sources of identifiers for the news sources or blogs you want
  *                headlines from Note: you can't mix this param with the country
  *                or category params
  * @param keyword Keywords or phrases to search for in the article title and body
  * @param pageSize The number of results to return per page.
  * @param page Use this to page through the results.
  */
case class HeadsLinesQuerySettings(country: Option[Country],
                                   category: Option[Category],
                                   sources: Set[String],
                                   keyword: Option[String],
                                   pageSize: Int = 10,
                                   page: Int = 1)
