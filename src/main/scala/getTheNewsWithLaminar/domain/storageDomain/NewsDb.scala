package getTheNewsWithLaminar.domain.storageDomain

import getTheNewsWithLaminar.domain.apiDomain.Article
import getTheNewsWithLaminar.domain.storageDomain.Enumerations.ArticlesUsersTags

/**
 * This object serves as a repository for any data to store
 */
object NewsDb:
  /**
   * The Key is the user id
   */
  val userNavHistoryDb: Map[String, Map[ArticlesUsersTags, List[Article]]] = Map()

  /**
   * The key is the user id, and the value is the encrypted password of the user
   */
  val usersKeysDb: Map[String, String] = Map()

  /**
   * collection of users
   */
  val usersDb: Set[User] = Set[User]()
