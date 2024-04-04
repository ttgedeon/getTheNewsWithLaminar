package getTheNewsWithLaminar.repositories.generics

case class RepositoryError(message: String) extends Throwable(message)
