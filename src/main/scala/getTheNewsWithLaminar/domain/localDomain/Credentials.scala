package getTheNewsWithLaminar.domain.localDomain

import upickle.default.*

case class Credentials(id: String, key: String) derives ReadWriter
