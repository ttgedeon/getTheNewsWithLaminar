package getTheNewsWithLaminar.domain.apiDomain

import Enumerations.ResponseStatus
import getTheNewsWithLaminar.domain.apiDomain.Article

case class NewsResponses(status: ResponseStatus,
                         totalResults: Int,
                         articles: List[Article])
