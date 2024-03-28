package getTheNewsWithLaminar.service
import getTheNewsWithLaminar.repository.Repository

trait Service[A <: {def id: String}]:

  def repository: Repository[A]

  def retrieve(id: String): ServiceError | A

  def create(value: A): ServiceError | A
  
  def update(value: A): ServiceError | A
  
  def delete(id: String): ServiceError | true
