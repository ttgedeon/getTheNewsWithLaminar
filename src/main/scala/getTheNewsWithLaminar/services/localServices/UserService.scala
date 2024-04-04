package getTheNewsWithLaminar.services.localServices

import getTheNewsWithLaminar.domain.localDomain.User
import getTheNewsWithLaminar.repositories.generics.{Repository, RepositoryError}
import getTheNewsWithLaminar.repositories.localRepository.UserRepository
import getTheNewsWithLaminar.services.generics.Service

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object UserService extends Service[User]:
  override val repository: Repository[User] = UserRepository
