package getTheNewsWithLaminar.domain.apiDomain

import getTheNewsWithLaminar.domain.apiDomain.Source

/**
  *
  * @param source
  * @param author
  * @param title
  * @param description
  * @param url
  * @param urlToImage
  * @param publishedAt
  * @param content
  */
case class Article(source: Source,
                   author: String,
                   title: String,
                   description: String,
                   url: String,
                   urlToImage: String,
                   publishedAt: String,
                   content: String)
