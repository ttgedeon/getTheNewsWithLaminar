package getTheNewsWithLaminar.repository

import getTheNewsWithLaminar.domain.storageDomain.NewsDb

trait Repository[A <: {def id: String}]:

  def db: NewsDb.type

  def getById(id: String):  RepositoryError | A

  def save(value: A):  RepositoryError |A

  def update(value: A):  RepositoryError |A

  def delete(id: String):  RepositoryError | true
