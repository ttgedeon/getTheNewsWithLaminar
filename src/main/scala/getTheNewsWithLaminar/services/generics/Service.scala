package getTheNewsWithLaminar.services.generics

import getTheNewsWithLaminar.domain.localDomain.User
import getTheNewsWithLaminar.repositories.generics.{Repository, RepositoryError}
import getTheNewsWithLaminar.services.localServices.UserService.repository


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Interface for all services. I provides all the CRUD operations
 * on any entity of type A
 * @tparam A entity type of the repositories
 */
trait Service[A <: {def id: String} | {def status: String}]:

  /**
   * Repository entry point that the actual services will use to
   * perform CRUD operations on any entity of type A
   * @return `Repository[A]`
   */
  def repository: Repository[A]

  /**
   * Retrieves an instance of entity `A`
   * @param id identifier of the entity `A`
   * @return `Future[ServiceError | A]`
   */
  def retrieve(id: String): Future[ServiceError | A] =
    repository.getById(id = id)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }

  /**
   * Retrieve all the instances of entity Credentials
   * @return `Future[ServiceError, Seq[A]]`
   */
  def list : Future[ServiceError | Seq[A] | A] =
    repository.getAll
      .map {
        case error: RepositoryError => ServiceError(error.message)
        case values => values.asInstanceOf[Seq[A]]
      }

  def listResponse : Future[ServiceError | A] =
    repository.getAll
      .map {
        case error: RepositoryError => ServiceError(error.message)
        case values => values.asInstanceOf[A]
      }

  /**
   * Creates an instance of type `A`
   * @param value instance to create
   * @return
   */
  def create(value: A): Future[ServiceError | A] =
    repository.save(value = value)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }

  /**
   * Update an existing instance of A to a new state described by the value A
   * @param value new state to persists
   * @return `Future[ServiceError | A]`
   */
  def update(value: A): Future[ServiceError | A] =
    repository.update(value = value)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }

  /**
   * Tries to delete an instance of Credentials if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return `Future[ServiceError | Credentials]`
   */
  def delete(id: String): Future[ServiceError | A] =
    repository.delete(id = id)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }
