package getTheNewsWithLaminar.domain

case class Article(source: Source,
                   author: String,
                   title: String,
                   description: String,
                   url: String,
                   urlToImage: String,
                   publishedAt: String,
                   content: String)
