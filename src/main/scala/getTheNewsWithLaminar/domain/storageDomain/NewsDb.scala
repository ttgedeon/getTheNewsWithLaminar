package getTheNewsWithLaminar.domain.storageDomain

import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.domain.storageDomain.Enumerations.ArticlesUsersTags
import getTheNewsWithLaminar.domain.apiDomain.Enumerations.{Api, Category, QueryKey}
import scala.collection.mutable.ArrayBuffer

trait NewsDb
/**
 * This object serves as a repository for any data to store
 */
object NewsDb:
  /**
   * This is the type for query parameters
   */
  type ParamType = Map[QueryKey, String | Seq[String] | Option[String]]
  
  /**
   * The Key is the user id
   */
  var userNavHistoryDb: Map[String, Map[ArticlesUsersTags, List[Article]]] = Map()

  /**
   * The key is the user id, and the value is the encrypted password of the user
   */
  var usersKeysDb: Map[String, String] = Map()

  /**
   * collection of users
   */
  var usersDb: Set[User] = Set[User]()

  /**
   * Users api query parameters
   */
  var usersApiQueryParams : Map[String, Map[Api, ArrayBuffer[ParamType]]] = Map()
  
  def getUserApiQueryParams(user: User, api: Api): Seq[ParamType] =
    usersApiQueryParams
      .filter(_._1 == user.id)(user.id)(api)
      .toSeq

  /**
   * This method store for a given api endpoint the parameters fo a given user
   * @param user  User for requesting the query parameters save
   * @param api Api entry point  enum value
   * @param params parameters to store
   * @return
   */
  def setUserApiQueryParams(user: User, api: Api, params: ArrayBuffer[ParamType])
  : Unit  =
    val userEntryExists: Boolean =
      this.usersApiQueryParams.exists(_._1 == user.id)

    if userEntryExists then
      val actualUserQueryParams: Map[Api, ArrayBuffer[ParamType]] =
        this.usersApiQueryParams(user.id)

      val userQueryParamsToKeep: Map[Api, ArrayBuffer[ParamType]] =
        actualUserQueryParams.filterNot(_._1 == api)

      val newUserQueryParamsSet: Map[Api, ArrayBuffer[ParamType]] =
        userQueryParamsToKeep + (api -> params)

      val s: Map[String, Map[Api, ArrayBuffer[ParamType]]] =
        usersApiQueryParams + (user.id -> newUserQueryParamsSet)

      this.usersApiQueryParams = s
    else
      val s: Map[String, Map[Api, ArrayBuffer[ParamType]]] =
        this.usersApiQueryParams + (user.id -> Map(api -> params))
      this.usersApiQueryParams = s