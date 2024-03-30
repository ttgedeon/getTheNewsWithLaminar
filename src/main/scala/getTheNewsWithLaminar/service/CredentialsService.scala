package getTheNewsWithLaminar.service

import getTheNewsWithLaminar.domain.storageDomain.Credentials
import getTheNewsWithLaminar.repository.CredentialsRepository
import getTheNewsWithLaminar.repository.Repository

object CredentialsService extends Service[Credentials]:
  override val repository: Repository[Credentials] = CredentialsRepository
