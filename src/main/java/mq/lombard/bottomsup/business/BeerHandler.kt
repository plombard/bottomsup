package mq.lombard.bottomsup.business;

import mq.lombard.bottomsup.Mapper
import mq.lombard.bottomsup.Utils
import mq.lombard.bottomsup.bean.BeerItem
import mq.lombard.bottomsup.bean.Glass
import mq.lombard.bottomsup.bean.GlassBuilder
import mq.lombard.bottomsup.dao.BeerDao
import java.util.stream.Collectors

/** @author Pascal Lombard */
object BeerHandler {

  fun pour(beerName: String): Glass {
    val beer = BeerDao.getBeer(beerName);
    // Utilisation de builder, de mapper et de parametres optionnels
    return GlassBuilder()
        .setBeerName(beer.getName())
        .setBeerStyle(Utils.alcoholToStyle(beer.getAlcohol()))
        .setToRefill(false)
        .build();
  }

  fun list(): Set<BeerItem> {
    return BeerDao.listBeers().stream().map(Mapper::fromBeer)
        .collect(Collectors.toSet());
  }
}
