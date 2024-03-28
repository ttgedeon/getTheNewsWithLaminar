package getTheNewsWithLaminar.domain.apiDomain

import getTheNewsWithLaminar.domain.apiDomain.Source

case class Article(source: Source,
                   author: String,
                   title: String,
                   description: String,
                   url: String,
                   urlToImage: String,
                   publishedAt: String,
                   content: String)
