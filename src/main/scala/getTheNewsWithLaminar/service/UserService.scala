package getTheNewsWithLaminar.service

import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.repository.Repository
import getTheNewsWithLaminar.repository.RepositoryError

import getTheNewsWithLaminar.repository.UserRepository
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object UserService extends Service[User]:
  override val repository: Repository[User] = UserRepository
