package getTheNewsWithLaminar.domain.apiDomain

/**
  * This class models the headlines API query settings for a user
  * @param country
  * @param category
  * @param sources
  * @param keyword
  * @param pageSize
  * @param page
  */
case class HeadsLinesQuerySettings(country: Option[String],
                                   category: Option[String],
                                   sources: List[String],
                                   keyword: Option[String],
                                   pageSize: Int = 10,
                                   page: Int = 1)
