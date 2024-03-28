package getTheNewsWithLaminar.domain.apiDomain

/**
 * This object contains the collection of enumerations used
 * in api modeling
 */
object Enumerations:
  /**
   * This enumeration contains the collection of tags used
   * to sort the articles returned by the new api
   * @param title ArticleSortCriteria tag
   */
  enum ArticleSortCriteria(title: String):
    case RELEVANCY extends ArticleSortCriteria(title = "relevancy")
    case POPULARITY extends ArticleSortCriteria(title = "popularity")
    case PUBLISHED_AT extends ArticleSortCriteria(title = "publishedAt")

  object ArticleSortCriteria:
    /**
     * Converts weighted Popularity actual value into an enumeration entry
     * @param title actual popularity value
     * @return Enumerations entry
     */
    def fromTitles(title: String): ArticleSortCriteria =
      title match
        case "relevancy" => ArticleSortCriteria.RELEVANCY
        case "popularity" => ArticleSortCriteria.POPULARITY
        case "publishedAt" => ArticleSortCriteria.PUBLISHED_AT
    end fromTitles
  end ArticleSortCriteria

  /**
   * This enumeration contains the collection of the categories
   * we want the headlines for
   */
  enum Category(title: String):
    case BUSINESS extends Category(title = "business")
    case ENTERTAINMENT extends Category(title = "entertainment")
    case HEALTH extends Category(title = "health")
    case SCIENCE extends Category(title = "science")
    case SPORTS extends Category(title = "sports")
    case TECHNOLOGY extends Category(title = "technology")

  object Category:
    /**
     * Converts the weighted API response category enumeration actual
     * value into an enumeration entry
     * @param title category enumeration actual value
     * @return  Category enumeration entry
     */
    def fromTitles(title: String): Category =
      title match
        case "business" => Category.BUSINESS
        case "entertainment" => Category.ENTERTAINMENT
        case "health" => Category.HEALTH
        case "science" => Category.SCIENCE
        case "sports" => Category.SPORTS
        case "technology" => Category.TECHNOLOGY
    end fromTitles
  end Category


  /**
   * This enumeration contains a collection of all possible countries
   * to use in the API category.
   */
  enum Country(title: String):
    case AE extends Country(title = "ae")
    case AR extends Country(title = "ar")
    case AT extends Country(title = "at")
    case AU extends Country(title = "au")
    case BE extends Country(title = "be")
    case BG extends Country(title = "bg")
    case BR extends Country(title = "br")
    case CA extends Country(title = "ca")
    case CH extends Country(title = "ch")
    case CN extends Country(title = "cn")
    case CO extends Country(title = "co")
    case CU extends Country(title = "cu")
    case CZ extends Country(title = "cz")
    case DE extends Country(title = "de")
    case EG extends Country(title = "eg")
    case FR extends Country(title = "fr")
    case GB extends Country(title = "gb")
    case GR extends Country(title = "gr")
    case HK extends Country(title = "hk")
    case HU extends Country(title = "hu")
    case ID extends Country(title = "id")
    case IE extends Country(title = "ie")
    case IL extends Country(title = "il")
    case IN extends Country(title = "in")
    case IT extends Country(title = "it")
    case JP extends Country(title = "jp")
    case KR extends Country(title = "kr")
    case LT extends Country(title = "lt")
    case LV extends Country(title = "lv")
    case MA extends Country(title = "ma")
    case MX extends Country(title = "mx")
    case MY extends Country(title = "my")
    case NG extends Country(title = "ng")
    case NL extends Country(title = "nl")
    case NO extends Country(title = "no")
    case NZ extends Country(title = "nz")
    case PH extends Country(title = "ph")
    case PL extends Country(title = "pl")
    case PT extends Country(title = "pt")
    case RO extends Country(title = "ro")
    case RS extends Country(title = "rs")
    case RU extends Country(title = "ru")
    case SA extends Country(title = "sa")
    case SE extends Country(title = "se")
    case SG extends Country(title = "sg")
    case SI extends Country(title = "si")
    case SK extends Country(title = "sk")
    case TH extends Country(title = "th")
    case TR extends Country(title = "tr")
    case TW extends Country(title = "tw")
    case UA extends Country(title = "ua")
    case US extends Country(title = "us")
    case VE extends Country(title = "ve")
    case ZA extends Country(title = "za")

  object Country:
    /**
     * Converts the weighted country enumerations actual abbreviations into
     * enumeration entries
     * @param title country abbreviation actual value
     */
    def fromTitles(title: String): Country =
      title match
        case "ae" => Country.AE
        case "ar" => Country.AR
        case "at" => Country.AT
        case "au" => Country.AU
        case "be" => Country.AU
        case "bg" => Country.BG
        case "br" => Country.BR
        case "ca" => Country.CA
        case "ch" => Country.CH
        case "cn" => Country.CN
        case "co" => Country.CO
        case "cu" => Country.CU
        case "cz" => Country.CZ
        case "de" => Country.DE
        case "eg" => Country.EG
        case "fr" => Country.FR
        case "gb" => Country.GB
        case "gr" => Country.GR
        case "hk" => Country.HK
        case "hu" => Country.HU
        case "id" => Country.ID
        case "ie" => Country.IE
        case "il" => Country.IL
        case "in" => Country.IN
        case "it" => Country.IT
        case "jp" => Country.JP
        case "kr" => Country.KR
        case "lt" => Country.LT
        case "lv" => Country.LV
        case "ma" => Country.MA
        case "mx" => Country.MX
        case "my" => Country.MY
        case "ng" => Country.NG
        case "nl" => Country.NL
        case "no" => Country.NO
        case "nz" => Country.NZ
        case "ph" => Country.PH
        case "pl" => Country.PL
        case "pt" => Country.PT
        case "ro" => Country.RO
        case "rs" => Country.RS
        case "ru" => Country.RU
        case "sa" => Country.SA
        case "se" => Country.SE
        case "sg" => Country.SG
        case "si" => Country.SI
        case "sk" => Country.SK
        case "th" => Country.TH
        case "tr" => Country.TR
        case "tw" => Country.TW
        case "ua" => Country.UA
        case "us" => Country.US
        case "ve" => Country.VE
        case "za" => Country.ZA


  /**
   * This enumeration contains the collection of tags used to
   * model the new api response status
   * @param title actual api response
   */
  enum ResponseStatus(title: String):
    case OK extends ResponseStatus(title = "ok")
    case ERROR extends ResponseStatus(title = "error")

  object ResponseStatus:
    /**
     * Converts weighted API response status enumeration actual value
     * into an enumeration entry
     * @param title response status enumeration actual value
     * @return ResponseStatus enumeration entry
     */
    def fromTitles(title: String): ResponseStatus =
      title match
        case "ok" => ResponseStatus.OK
        case "error" => ResponseStatus.ERROR
    end fromTitles
  end ResponseStatus

  /**
   * This enumeration contains the collection of articles fields
   * to search in
   * @param title actual search in field
   */
  enum SearchInFields(title: String):
    case TITLE extends SearchInFields(title = "title")
    case DESCRIPTION extends SearchInFields(title = "description")
    case CONTENT extends SearchInFields(title = "content")

  object SearchInFields:
    /**
     * Converts search in enumeration entry into an actual value
     * @param title search in actual value
     * @return SearchInFields enumeration entry
     */
    def fromTitle(title: String): SearchInFields =
      title match
        case "title"  => SearchInFields.TITLE
        case "description" => SearchInFields.DESCRIPTION
        case "content" => SearchInFields.CONTENT


  enum Languages(title: String):
    case AR extends Languages(title = "ar")
    case DE extends Languages(title = "de")
    case EN extends Languages(title = "en")
    case ES extends Languages(title = "es")
    case FR extends Languages(title = "fr")
    case HE extends Languages(title = "he")
    case IT extends Languages(title = "it")
    case NL extends Languages(title = "nl")
    case NO extends Languages(title = "no")
    case PT extends Languages(title = "pt")
    case RU extends Languages(title = "ru")
    case SV extends Languages(title = "sv")
    case UD extends Languages(title = "ud")
    case ZH extends Languages(title = "zh")

  object Languages:
    /**
     * Converts Languages enumeration entry into an actual value
     * @param title search in actual value
     * @return Languages enumeration entry
     */
    def fromTitles(title: String): Languages =
      title match
        case "ar" => Languages.AR
        case "de" => Languages.DE
        case "en" => Languages.EN
        case "es" => Languages.ES
        case "fr" => Languages.FR
        case "he" => Languages.HE
        case "it" => Languages.IT
        case "nl" => Languages.NL
        case "no" => Languages.NO
        case "pt" => Languages.NO
        case "ru" => Languages.RU
        case "sv" => Languages.SV
        case "ud" => Languages.UD
        case "zh" => Languages.ZH

end Enumerations
