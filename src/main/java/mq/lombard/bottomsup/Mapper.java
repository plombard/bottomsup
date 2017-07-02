package mq.lombard.bottomsup;

import mq.lombard.bottomsup.bean.BeerItem;
import mq.lombard.bottomsup.thirdparty.Beer;

/** @author Pascal Lombard */
public class Mapper {

  public static BeerItem fromBeer(Beer beer) {
    return new BeerItem(
        beer.getName(), beer.getDescription(), Utils.alcoholToStyle(beer.getAlcohol()));
  }
}
