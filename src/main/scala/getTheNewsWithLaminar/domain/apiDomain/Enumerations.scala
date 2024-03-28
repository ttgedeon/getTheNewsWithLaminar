package getTheNewsWithLaminar.domain.apiDomain

object DomainEnumerations:
  enum Popularity(title: String):
    case RELEVANCY extends Popularity(title = "relevancy")
    case POPULARITY extends Popularity(title = "popularity")
    case PUBLISHED_AT extends Popularity(title = "publishedAt")

  object Popularity:
    def fromTitles(title: String): Popularity =
      title match
        case "relevancy" => Popularity.RELEVANCY
        case "popularity" => Popularity.POPULARITY
        case "publishedAt" => Popularity.PUBLISHED_AT
    end fromTitles
  end Popularity


  enum ResponseStatus(title: String):
    case OK extends ResponseStatus(title = "ok")
    case ERROR extends ResponseStatus(title = "error")

  object ResponseStatus:
    def fromTitles(title: String): ResponseStatus =
      title match
        case "ok" => ResponseStatus.OK
        case "error" => ResponseStatus.ERROR
    end fromTitles
  end ResponseStatus


  enum ArticlesUsersTags(title: String):
    case LIKED extends ArticlesUsersTags(title = "liked")
    case SAVED extends ArticlesUsersTags(title = "saved")

  object ArticlesUsersTags:
    def fromTitles(title: String): ArticlesUsersTags =
      title match
        case "liked" => ArticlesUsersTags.LIKED
        case "saved" => ArticlesUsersTags.SAVED

end DomainEnumerations
