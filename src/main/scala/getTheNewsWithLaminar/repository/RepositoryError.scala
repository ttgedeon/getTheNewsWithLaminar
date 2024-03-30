package getTheNewsWithLaminar.repository

case class RepositoryError(message: String) extends Throwable(message)
