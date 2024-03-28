package getTheNewsWithLaminar.domain.storageDomain

object Enumerations:
  enum ArticlesUsersTags(title: String):
    case LIKED extends ArticlesUsersTags(title = "liked")
    case SAVED extends ArticlesUsersTags(title = "saved")
    case OPENED extends ArticlesUsersTags(title = "opened")

  object ArticlesUsersTags:
    def fromTitles(title: String): ArticlesUsersTags =
      title match
        case "liked" => ArticlesUsersTags.LIKED
        case "saved" => ArticlesUsersTags.SAVED
        case "opened" => ArticlesUsersTags.OPENED
