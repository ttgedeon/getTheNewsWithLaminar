package getTheNewsWithLaminar.domain.storageDomain

import getTheNewsWithLaminar.domain.apiDomain.Article
import Enumerations.ArticlesUsersTags

/**
  * This class models a given user activity history that is stored into
  * the database
  * @param userId  user id
  * @param history activity history
  */
case class UserNewsHistory(userId: String,
                           history: Map[ArticlesUsersTags, List[Article]])
