package getTheNewsWithLaminar.service

import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.repository.Repository
import getTheNewsWithLaminar.repository.{UserRepository, RepositoryError}


object UserService extends Service[User]:

  override val repository: Repository[User] = UserRepository

  override def retrieve(id: String): ServiceError | User =
    repository.getById(id = id) match
      case error : RepositoryError => ServiceError(error.message)
      case user: User => user

  override def create(value: User): ServiceError | User =
    repository.save(value = value) match
      case error : RepositoryError => ServiceError(error.message)
      case user : User => user

  override def update(value: User): ServiceError | User =
    repository.update(value = value) match
      case error : RepositoryError => ServiceError(error.message)
      case user : User => user

  override def delete(id: String): ServiceError | true =
    repository.delete(id)  match
      case error : RepositoryError => ServiceError(error.message)
      case _ : Boolean => true