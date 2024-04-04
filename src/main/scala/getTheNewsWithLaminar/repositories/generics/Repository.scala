package getTheNewsWithLaminar.repositories.generics

import getTheNewsWithLaminar.domain.localDomain.NewsDb
import sttp.client4.quick.quickRequest
import sttp.client4.PartialRequest

import scala.concurrent.Future

/**
 * This is a repositories interface for all the entities
 * of which the hole life cycle is managed by us
 * @tparam A Entity managed by the repositories
 */
trait Repository[A <: {def id: String} | {def status: String}]:

  /**
   * main endpoint for the repositories
   */
  def mainEndpoint: String

  /**
   * sttp client request initiator
   */
  val requestInit: PartialRequest[String] = quickRequest

  /**
   * Retrieve an instance of entity
   * @param id identifier of the entity to retrieve
   * @return `Future[RepositoryError | A]`
   */
  def getById(id: String):  Future[RepositoryError | A]

  /**
   * Retrieve all the instances of entity A
   * @return `Future[RepositoryError | Seq[A] | A]`
   */
  def getAll: Future[RepositoryError | Seq[A] | A]

  /**
   * Tries to save an instance of A
   * @param value instance of A to save
   * @return `Future[RepositoryError | A]`
   */
  def save(value: A):  Future[RepositoryError | A]

  /**
   * Updates an instance of A if its identifier has been saved
   * @param value instance of A to update
   * @return `Future[RepositoryError | A]`
   */
  def update(value: A):  Future[RepositoryError | A]

  /**
   * Tries to delete an instance of A if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return `Future[RepositoryError | A]`
   */
  def delete(id: String): Future[RepositoryError | A]
