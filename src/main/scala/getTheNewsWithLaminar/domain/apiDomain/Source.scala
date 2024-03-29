package getTheNewsWithLaminar.domain.apiDomain

import upickle.default.*

/**
  * This class models the new publishers that top headlines
  * @param id The identifier of the news source. You can use this with our other endpoints.
  * @param name The name of the news source
  * @param description A description of the news source
  * @param url The URL of the homepage.
  * @param category The type of news to expect from this news source.
  * @param language The language that this news source writes in
  * @param country The country this news source is based in (and primarily writes about)
  */
case class Source(id: String,
                  name: String,
                  description: String,
                  url: String,
                  category: String,
                  language: String,
                  country: String) derives ReadWriter
