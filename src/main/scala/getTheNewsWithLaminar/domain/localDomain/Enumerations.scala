package getTheNewsWithLaminar.domain.localDomain

/**
 * This enumeration contains the possible actions of a user vs a
 * given article
 */
object Enumerations:
  enum ArticlesUsersTags(title: String):
    case LIKED extends ArticlesUsersTags(title = "liked")
    case SAVED extends ArticlesUsersTags(title = "saved")
    case OPENED extends ArticlesUsersTags(title = "opened")

  object ArticlesUsersTags:
    /**
     * Converts an ArticlesUsersTags enumeration entry into an
     * actual value
     * @param title ArticlesUsersTags enumeration entry
     * @return ArticlesUsersTags
     */
    def fromTitles(title: String): ArticlesUsersTags =
      title match
        case "liked" => ArticlesUsersTags.LIKED
        case "saved" => ArticlesUsersTags.SAVED
        case "opened" => ArticlesUsersTags.OPENED
