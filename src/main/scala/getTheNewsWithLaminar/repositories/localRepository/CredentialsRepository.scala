package getTheNewsWithLaminar.repositories.localRepository

import getTheNewsWithLaminar.domain.localDomain.Credentials
import getTheNewsWithLaminar.repositories.generics.{Repository, RepositoryError}
import getTheNewsWithLaminar.repositories.localRepository.CredentialsRepository.requestInit
import sttp.client4.Response
import sttp.client4.quick.*
import upickle.default.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/**
 * Repository instance for the `Credentials`
 */
object CredentialsRepository extends Repository[Credentials]

  :

  /**
   * main endpoint for the user repositories
   */
  override val mainEndpoint: String = "http://localhost:3000/credentials"

  /**
   * Retrieve an instance of entity
   * @param id identifier of the entity to retrieve
   * @return `Future[RepositoryError | Credentials]`
   */
  override def getById(id: String): Future[RepositoryError | Credentials] =
    requestInit
      .get(uri"$mainEndpoint/$id")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) != 2 then
          Future.failed[RepositoryError](RepositoryError("No such element found"))
        else Future.successful[Credentials](read[Credentials](response.body))
      }

  /**
   * Retrieve all the instances of entity Credentials
   * @return `Future[RepositoryError, Seq[Credentials]]`
   */
  override def getAll: Future[RepositoryError | Seq[Credentials]] =
    requestInit
      .get(uri"$mainEndpoint")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) != 2 then
          Future.failed[RepositoryError](RepositoryError("Not able to get all"))
        else Future.successful[List[Credentials]](read[List[Credentials]](response.body))
      }

  /**
   * Tries to save an instance of Credentials
   * @param value instance of Credentials to save
   * @return `Future[RepositoryError | Credentials]`
   */
  override def save(value: Credentials): Future[RepositoryError | Credentials] =
    requestInit
      .post(uri"$mainEndpoint")
      .header("Content-Type", "application/json")
      .body(write(value))
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) != 2 then
          Future.failed[RepositoryError](
            RepositoryError("Not able to create such element"))
        else Future.successful[Credentials](read[Credentials](response.body))
      }

  /**
   * Updates an instance of Credentials if its identifier has been saved
   * @param value instance of Credentials to update
   * @return `Future[RepositoryError | Credentials]`
   */
  override def update(value: Credentials): Future[RepositoryError | Credentials] =
    requestInit
      .patch(uri"$mainEndpoint/${value.id}")
      .header("Content-Type", "application/json")
      .body(write(value))
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) != 2 then
          Future.failed[RepositoryError](
            RepositoryError("Not able to update such element"))
        else Future.successful[Credentials](read[Credentials](response.body))
      }

  /**
   * Tries to delete an instance of Credentials if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return `Future[RepositoryError | Credentials]`
   */
  override def delete(id: String): Future[RepositoryError | Credentials] =
    requestInit
      .delete(uri"$mainEndpoint/$id")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) != 2 then
          Future.failed[RepositoryError](RepositoryError("Not able to delete such element"))
        else Future.successful[Credentials](read[Credentials](response.body))
      }
