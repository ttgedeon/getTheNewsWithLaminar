package getTheNewsWithLaminar.repository

import getTheNewsWithLaminar.domain.storageDomain.User
import sttp.client4.quick.*
import sttp.client4.Response
import upickle.default.*
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object UserRepository extends Repository[User]:

  /**
   * main endpoint for the user repository
   */
  override val mainEndpoint: String = "http://localhost:3000/users"

  /**
   * Retrieve an instance of entity
   * @param id identifier of the entity to retrieve
   * @return RepositoryError | User
   */
  override def getById(id: String): Future[RepositoryError | User] =
    requestInit
      .get(uri"$mainEndpoint/$id")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](RepositoryError("No such element found"))
        else Future.successful[User](read[User](response.body))
      }

  /**
   * Retrieve all the instances of entity User
   * @return `Future[RepositoryError, Seq[User]]`
   */
  override def getAll: Future[RepositoryError | Seq[User]] =
    requestInit
      .get(uri"$mainEndpoint")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](RepositoryError("Not able to get all"))
        else Future.successful[List[User]](read[List[User]](response.body))
      }


  /**
   * Tries to save an instance of User
   * @param value instance of User to save
   * @return RepositoryError | User
   */
  override def save(value: User): Future[RepositoryError | User] =
    requestInit
      .post(uri"$mainEndpoint")
      .header("Content-Type", "application/json")
      .body(write(value))
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](
            RepositoryError("Not able to create such element"))
        else Future.successful[User](read[User](response.body))
      }

  /**
   * Updates an instance of User if its identifier has been saved
   * @param value instance of User to update
   * @return RepositoryError | User
   */
  override def update(value: User): Future[RepositoryError | User] =
    requestInit
      .patch(uri"$mainEndpoint/${value.id}")
      .header("Content-Type", "application/json")
      .body(write(value))
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](
            RepositoryError("Not able to update such element"))
        else Future.successful[User](read[User](response.body))
      }

  /**
   * Tries to delete an instance of User if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return RepositoryError | User
   */
  override def delete(id: String): Future[RepositoryError | User] =
    requestInit
      .delete(uri"$mainEndpoint/$id")
      .header("Content-Type", "application/json")
      .send()
      .flatMap { (response: Response[String]) =>
        if response.code.toString.charAt(0) == 4 then
          Future.failed[RepositoryError](RepositoryError("Not able to delete such element"))
        else Future.successful[User](read[User](response.body))
      }
