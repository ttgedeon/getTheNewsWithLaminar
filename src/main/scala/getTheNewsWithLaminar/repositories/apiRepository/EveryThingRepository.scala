package getTheNewsWithLaminar.repositories.apiRepository

import getTheNewsWithLaminar.domain.apiDomain.NewsResponse
import getTheNewsWithLaminar.domain.localDomain.User
import getTheNewsWithLaminar.domain.apiDomain.Enumerations
import getTheNewsWithLaminar.domain.apiDomain.Enumerations.Api
import getTheNewsWithLaminar.domain.localDomain.NewsDb.ParamType
import scala.collection.mutable.ArrayBuffer


/**
 * This repositories
 */
object EveryThingRepository extends NewsAPIRepository[NewsResponse]:

  /**
   * API key required for making the API request to retrieve the news articles
   * @return Actual api key
   */
  override lazy val newApiKey: String =
    val apiKey: String = System.getenv("ApiKey")
    if apiKey.nonEmpty then apiKey else "63b223ccd5ad44368c4acb95f7af2f96"

  override def api: Enumerations.Api = Enumerations.Api.Everything

  override def getUserQueryParameters(user: User, api: Api): ArrayBuffer[ParamType] = ???

  override def fetch(user: User): List[NewsResponse] = ???
