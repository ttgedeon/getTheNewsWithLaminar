package getTheNewsWithLaminar.repositories.apiRepository

import getTheNewsWithLaminar.domain.apiDomain.NewsResponse
import getTheNewsWithLaminar.repositories.generics.{Repository, RepositoryError}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import sttp.client4.quick.*
import sttp.client4.Response
import upickle.default.*

object NewsRepository extends Repository[NewsResponse]:

  /**
   * main endpoint for the user repositories
   */
  override val mainEndpoint: String = "https://newsapi" +
    ".org/v2/everything?q=sports&q=politics&q=science&q=intelligence&apiKey" +
    "=63b223ccd5ad44368c4acb95f7af2f96"

  /**
   * Retrieve an instance of entity
   * @param id identifier of the entity to retrieve
   * @return RepositoryError | NewsResponse
   */
  override def getById(id: String): Future[RepositoryError | NewsResponse] = ???

  /**
   * Retrieve all the instances of entity NewsResponse
   * @return `Future[RepositoryError, NewsResponse]`
   */
  override def getAll: Future[RepositoryError | NewsResponse] =
    requestInit
      .get(uri"$mainEndpoint")
//      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](RepositoryError("Not able to get the news"))
        else Future.successful[NewsResponse](read[NewsResponse](response.body))
      }


  /**
   * Tries to save an instance of NewsResponse
   * @param value instance of NewsResponse to save
   * @return RepositoryError | NewsResponse
   */
  override def save(value: NewsResponse): Future[RepositoryError | NewsResponse] = ???

  /**
   * Updates an instance of NewsResponse if its identifier has been saved
   * @param value instance of NewsResponse to update
   * @return RepositoryError | NewsResponse
   */
  override def update(value: NewsResponse): Future[RepositoryError | NewsResponse] = ???

  /**
   * Tries to delete an instance of NewsResponse if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return RepositoryError | NewsResponse
   */
  override def delete(id: String): Future[RepositoryError | NewsResponse] = ???
