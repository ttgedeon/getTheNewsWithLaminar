package getTheNewsWithLaminar.repository

import getTheNewsWithLaminar.domain.storageDomain.NewsDb

/**
 * This is a repository interface for all the entities
 * of which the hole life cycle is managed by us
 * @tparam A Entity managed by the repository
 */
trait Repository[A <: {def id: String}]:

  /**
   * instance of data store
   * @return
   */
  def db: NewsDb.type

  /**
   * Retrieve an instance of entity
   * @param id identifier of the entity to retrieve
   * @return RepositoryError | A
   */
  def getById(id: String):  RepositoryError | A

  /**
   * Tries to save an instance of A
   * @param value instance of A to save
   * @return RepositoryError |A
   */
  def save(value: A):  RepositoryError |A

  /**
   * Updates an instance of A if its identifier has been saved
   * @param value instance of A to update
   * @return RepositoryError |A
   */
  def update(value: A):  RepositoryError |A

  /**
   * Tries to delete an instance of A if it is effectively in the
   * store
   * @param id identifier of the instance to delete
   * @return RepositoryError | true
   */
  def delete(id: String):  RepositoryError | true
