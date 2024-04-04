package getTheNewsWithLaminar.repositories.apiRepository

import getTheNewsWithLaminar.domain.localDomain.User
import getTheNewsWithLaminar.domain.apiDomain.Enumerations.Api
import getTheNewsWithLaminar.domain.localDomain.NewsDb.ParamType

import scala.collection.mutable.ArrayBuffer


/**
 * This is the interface for all repositories performing
 * The fetch operations on the NewsAPI
 * @tparam A entity type returned by the fetch operation
 */
trait NewsAPIRepository[A]:

  /**
   * API key required for making the API request
   * @return Actual api key
   */
  def newApiKey: String

  /**
   * The endpoint that will be used for all fetch operations fo this repositories
   * @return actual endpoint as string
   */
  def api: Api

  /**
   * Returns for a given user the set
   * @param user user for which the query parameters are required
   * @return `Map[String, String | Seq[String] | Option[String]]`
   */
  def getUserQueryParameters(user: User, api: Api): ArrayBuffer[ParamType]

  /**
   * This method performs for a given user having saved the given
   * parameters the fetch operation which return the list of entities of
   * type A
   * @param user user performing the fetch operation
   * @return `List[A]`
   */
  def fetch(user: User): List[A]