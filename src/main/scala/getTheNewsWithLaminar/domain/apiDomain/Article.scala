package getTheNewsWithLaminar.domain.apiDomain

import upickle.default.*

import getTheNewsWithLaminar.domain.apiDomain.Source

/**
  * A news article published
  * @param source identifier of the source
  * @param author author of the article
  * @param title title of the article
  * @param description description of the article
  * @param url address of the article
  * @param urlToImage article image address
  * @param publishedAt article publication date
  * @param content article content
  */
case class Article(source: LightSource,
                   author: String,
                   title: String,
                   description: String,
                   url: String,
                   urlToImage: String,
                   publishedAt: String,
                   content: String) derives ReadWriter
