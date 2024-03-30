package getTheNewsWithLaminar.domain.apiDomain

import upickle.default.*

import Enumerations.ResponseStatus
import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.domain.apiDomain.Enumerations.ResponseStatus

/**
  * News api response object model
  * @param status If the request was successful or not. Options: ok, error. In
  *               the case of error a code and message property will be populated
  * @param totalResults The total number of results available for your request.
  *                     Only a limited number are shown at a time though, so use
  *                     the page parameter in your requests to page through them
  * @param articles The results of the request.
  */
case class NewsResponse(status: String,
                        totalResults: Int,
                        articles: List[Article]) derives ReadWriter
