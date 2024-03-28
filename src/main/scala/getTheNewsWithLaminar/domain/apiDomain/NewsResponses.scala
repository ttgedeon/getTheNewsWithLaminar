package getTheNewsWithLaminar.domain

import DomainEnumerations.ResponseStatus

case class NewsResponses(status: ResponseStatus,
                         totalResults: Int,
                         articles: List[Article])
