package getTheNewsWithLaminar.repository

import getTheNewsWithLaminar.domain.storageDomain.User
import getTheNewsWithLaminar.domain.storageDomain.NewsDb

/**
 * User repository responsible for all CRUD operations
 * related to the User 
 */
object UserRepository extends Repository[User]:

  /**
   * data store
   */
  override val db: NewsDb.type = NewsDb

  /**
   * Get a user using it's identifier
   * @param id user identifier
   * @return RepositoryError | User
   */
  override def getById(id: String): RepositoryError | User =

    val s: Set[User] = db.usersDb.filter((_: User).id == id)
    if s.isEmpty then RepositoryError("No such user in the database")
    else s.head

  /**
   * Create a new user
   * @param value user object to save
   * @return RepositoryError | User
   */
  override def save(value: User): RepositoryError | User =

    val userSaved: Boolean = db.usersDb(value.copy(isAuthenticated = true))
    if userSaved then db.usersDb.filter((_: User).id == value.id).head
    else RepositoryError("Not able to store the user")

  /**
   * Update a user with the new attributes values, having kept the identifier
   * of the user
   * @param value user object to update
   * @return RepositoryError | User
   */
  override def update(value: User): RepositoryError | User =

    val userSet: Set[User] = db.usersDb.filter((_: User).id == value.id)
    if  userSet.nonEmpty then
      val _: Set[User] = db.usersDb.removedAll(userSet)
      db.usersDb(value)
      value
    else
      RepositoryError("The update operation was unsuccessfully performed")


  /**
   * Delete an object from the database
   * @param id identifier of the user to update
   * @return RepositoryError | true
   */
  override def delete(id: String): RepositoryError | true =

    val userSet: Set[User] = db.usersDb.filter((_: User).id == id)
    if  userSet.nonEmpty then
      val userRemoved: Set[User] = db.usersDb.removedAll(userSet)
      // todo Remove all the users related data before removing the user itself
      db.usersDb = userRemoved
      true
    else
      RepositoryError("User not found")

  /**
   * Update a given user password
   * @param userId  User identifier
   * @param newPassword new user password
   * @param oldPassword old user password
   * @return RepositoryError | true
   */
  def updateUserPassword(userId: String, newPassword: String, oldPassword: String)
    : RepositoryError | true =

      val userKeys: Map[String, String] =
        db.usersKeysDb.filter((k: (String, String)) => k._1 == userId & k._2 == oldPassword)

      if userKeys.nonEmpty then
        db.usersKeysDb = db.usersKeysDb.updated(userId, newPassword)
        true
      else RepositoryError("Unable to update the password")

  /**
   * Create a user password
   * @param userId User identifier
   * @param password User password
   * @return RepositoryError | true
   */
  def setUserPassword(userId: String, password: String) : RepositoryError | true =

      val userKeys: Map[String, String] =
        db.usersKeysDb.filter((k: (String, String)) => k._1 == userId & k._2 == password)

      if userKeys.nonEmpty then
        RepositoryError("This user already has an credentials saved")
      else
        db.usersKeysDb = db.usersKeysDb.updated(userId, password)
        true
