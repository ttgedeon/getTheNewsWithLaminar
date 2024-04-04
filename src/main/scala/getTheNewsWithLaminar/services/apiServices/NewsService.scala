package getTheNewsWithLaminar.services.apiServices

import getTheNewsWithLaminar.domain.apiDomain.{Article, NewsResponse}
import getTheNewsWithLaminar.repositories.generics.Repository
import getTheNewsWithLaminar.services.generics.Service
import getTheNewsWithLaminar.repositories.apiRepository.NewsRepository
import getTheNewsWithLaminar.repositories.generics.RepositoryError
import getTheNewsWithLaminar.services.generics.ServiceError

import scala.concurrent.Future
implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

object NewsService extends Service[NewsResponse]:
  override def repository: Repository[NewsResponse] = NewsRepository

    /**
     * Retrieve all the instances of entity Credentials
     * @return `Future[ServiceError, Seq[Credentials]]`
     */
    override def list : Future[ServiceError | NewsResponse] =
      repository.getAll
        .map {
          case error: RepositoryError => ServiceError(error.message)
          case values => values.asInstanceOf[NewsResponse]
        }
