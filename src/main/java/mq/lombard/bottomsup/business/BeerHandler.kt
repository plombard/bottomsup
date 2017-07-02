package mq.lombard.bottomsup.business

import mq.lombard.bottomsup.alcoholToStyle
import mq.lombard.bottomsup.bean.BeerItem
import mq.lombard.bottomsup.bean.Glass
import mq.lombard.bottomsup.bean.GlassBuilder
import mq.lombard.bottomsup.dao.BeerDao
import mq.lombard.bottomsup.thirdparty.Beer
import mq.lombard.bottomsup.toBeerItem
import java.util.stream.Collectors

/** @author Pascal Lombard */
object BeerHandler {

  fun pour(beerName: String): Glass {
    val beer = BeerDao.getBeer(beerName)
    // Utilisation de builder, de mapper et de parametres optionnels
    return GlassBuilder()
        .setBeerName(beer.name)
        .setBeerStyle(beer.alcohol.alcoholToStyle())
        .setToRefill(false)
        .build()
  }

  fun list(): Set<BeerItem> {
    return BeerDao.listBeers().stream().map(Beer::toBeerItem)
        .collect(Collectors.toSet())
  }
}
