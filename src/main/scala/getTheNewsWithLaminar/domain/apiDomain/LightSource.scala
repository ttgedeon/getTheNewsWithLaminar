package getTheNewsWithLaminar.domain.apiDomain

import upickle.default.*

/**
  * * This class models the new publishers that top headlines
  * as returned by the new api when articles are fetched
  * @param id The identifier of the news source. You can use this with our other endpoints.
  * @param name The name of the news source
  */
case class LightSource(id: String, name: String) derives ReadWriter
