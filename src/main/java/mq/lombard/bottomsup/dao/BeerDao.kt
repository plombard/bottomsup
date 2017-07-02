package mq.lombard.bottomsup.dao

import mq.lombard.bottomsup.thirdparty.Beer
import mq.lombard.bottomsup.thirdparty.BeerApi

/** @author Pascal Lombard
 */
object BeerDao {

  fun getBeer(name: String): Beer {
    return BeerApi.get(name)
  }

  fun listBeers(): Set<Beer> {
    return BeerApi.list()
  }
}
