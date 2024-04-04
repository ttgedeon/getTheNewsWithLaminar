package getTheNewsWithLaminar.services.localServices

import getTheNewsWithLaminar.domain.localDomain.Credentials
import getTheNewsWithLaminar.repositories.generics.Repository
import getTheNewsWithLaminar.repositories.localRepository.CredentialsRepository
import getTheNewsWithLaminar.services.generics.Service

/**
 * This object is the entry point for all the operations
 * related to the `Credentials` model
 */
object CredentialsService extends Service[Credentials]:
  override val repository: Repository[Credentials] = CredentialsRepository
