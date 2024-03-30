package getTheNewsWithLaminar.service

import getTheNewsWithLaminar.domain.storageDomain.Credentials
import getTheNewsWithLaminar.repository.CredentialsRepository
import getTheNewsWithLaminar.repository.Repository

/**
 * This object is the entry point for all the operations
 * related to the `Credentials` model
 */
object CredentialsService extends Service[Credentials]:
  override val repository: Repository[Credentials] = CredentialsRepository
