package getTheNewsWithLaminar.domain.apiDomain

abstract class HeadsLinesQuerySettings(country: Option[String],
                                       category: Option[String],
                                       sources: List[String],
                                       keyword: Option[String],
                                       pageSize: Int = 10,
                                       page: Int = 1)
