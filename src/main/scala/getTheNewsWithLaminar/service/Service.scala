package getTheNewsWithLaminar.service
import getTheNewsWithLaminar.repository.Repository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.repository.RepositoryError
import getTheNewsWithLaminar.service.UserService.repository

import scala.util.{Success, Failure}

/**
 * Interface for all services. I provides all the CRUD operations
 * on any entity of type A
 * @tparam A entity type of the repository
 */
trait Service[A <: {def id: String}]:

  /**
   * Repository entry point that the actual service will use to
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
   * @return `Future[ServiceError, Seq[Credentials]]`
   */
  def list : Future[ServiceError | Seq[A]] =
    repository.getAll
      .map {
        case error: RepositoryError => ServiceError(error.message)
        case values => values.asInstanceOf[Seq[A]]
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
