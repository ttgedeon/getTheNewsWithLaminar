package getTheNewsWithLaminar.domain.storageDomain

import upickle.default.*

case class Credentials(id: String, key: String) derives ReadWriter
