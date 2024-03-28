package getTheNewsWithLaminar.repository

import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.domain.storageDomain.NewsDb

object UserRepository extends Repository[User]:

  override val db: NewsDb.type = NewsDb

  override def getById(id: String): RepositoryError | User =
    val s: Set[User] = db.usersDb.filter((_: User).id == id)
    if s.isEmpty then RepositoryError("No such user in the database")
    else s.head

  override def save(value: User): RepositoryError | User =
    val userSaved: Boolean = db.usersDb(value.copy(isAuthenticated = true))
    if userSaved then db.usersDb.filter((_: User).id == value.id).head
    else RepositoryError("Not able to store the user")

  override def update(value: User): RepositoryError | User =
    val userSet: Set[User] = db.usersDb.filter((_: User).id == value.id)
    if  userSet.nonEmpty then
      val _: Set[User] = db.usersDb.removedAll(userSet)
      db.usersDb(value)
      value
    else
      RepositoryError("The update operation was unsuccessfully performed")


  override def delete(id: String): RepositoryError | true =
    val userSet: Set[User] = db.usersDb.filter((_: User).id == id)
    if  userSet.nonEmpty then
      val _: Set[User] = db.usersDb.removedAll(userSet)
      true
    else
      RepositoryError("User not found")




