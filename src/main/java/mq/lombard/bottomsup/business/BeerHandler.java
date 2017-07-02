package mq.lombard.bottomsup.business;

import mq.lombard.bottomsup.Mapper;
import mq.lombard.bottomsup.Utils;
import mq.lombard.bottomsup.bean.BeerItem;
import mq.lombard.bottomsup.bean.Glass;
import mq.lombard.bottomsup.bean.GlassBuilder;
import mq.lombard.bottomsup.dao.BeerDao;
import mq.lombard.bottomsup.thirdparty.Beer;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/** @author Pascal Lombard */
public class BeerHandler {
  private static BeerHandler ourInstance = new BeerHandler();

  private BeerHandler() {}

  public static BeerHandler getInstance() {
    return ourInstance;
  }

  public Glass pour(String beerName) {
    Beer beer = BeerDao.getInstance().getBeer(beerName);
    // Utilisation de builder, de mapper et de parametres optionnels
    return new GlassBuilder()
        .setBeerName(beer.getName())
        .setBeerStyle(Utils.alcoholToStyle(beer.getAlcohol()))
        .setToRefill(false)
        .build();
  }

  public Set<BeerItem> list() {
    return new HashSet<>(
        BeerDao.getInstance().listBeers().stream().map(Mapper::fromBeer).collect(toSet()));
  }
}
