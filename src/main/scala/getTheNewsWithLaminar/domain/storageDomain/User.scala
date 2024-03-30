package getTheNewsWithLaminar.domain.storageDomain

import upickle.default.*

/**
  * The User model
  * @param id User id(uuid)
  * @param firstName User first name
  * @param lastName User last nane
  * @param email User email
  */
case class User(id: String,
                firstName: String,
                lastName: String,
                email: String,
                picture: Option[String],
                isAuthenticated: Boolean = false) derives ReadWriter
