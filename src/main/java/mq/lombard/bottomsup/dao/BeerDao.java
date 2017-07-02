package mq.lombard.bottomsup.dao;

import mq.lombard.bottomsup.thirdparty.Beer;
import mq.lombard.bottomsup.thirdparty.BeerApi;

import java.util.Set;

/** @author Pascal Lombard */
public class BeerDao {

  // Singleton
  private static BeerDao ourInstance = new BeerDao();

  private BeerDao() {}

  public static BeerDao getInstance() {
    return ourInstance;
  }

  public Beer getBeer(String name) {
    return BeerApi.get(name);
  }

  public Set<Beer> listBeers() {
    return BeerApi.list();
  }
}
