package getTheNewsWithLaminar.service
import getTheNewsWithLaminar.repository.Repository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.repository.RepositoryError
import getTheNewsWithLaminar.service.UserService.repository

import scala.util.{Success, Failure}


trait Service[A <: {def id: String}]:

  def repository: Repository[A]

  def retrieve(id: String): Future[ServiceError | A] =
    repository.getById(id = id)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }

  def create(value: A): Future[ServiceError | A] =
    repository.save(value = value)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }
  
  def update(value: A): Future[ServiceError | A] =
    repository.update(value = value)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }
  
  def delete(id: String): Future[ServiceError | A] =
    repository.delete(id = id)
      .map { (response: RepositoryError | A) =>
        response match
          case error : RepositoryError => ServiceError(error.message)
          case value => value.asInstanceOf[A]
      }

  def list : Future[ServiceError | Seq[A]] =
    repository.getAll
      .map {
        case error: RepositoryError => ServiceError(error.message)
        case values => values.asInstanceOf[Seq[A]]
      }
