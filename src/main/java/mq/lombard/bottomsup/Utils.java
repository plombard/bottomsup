package mq.lombard.bottomsup;

import mq.lombard.bottomsup.bean.BeerStyle;

/** @author Pascal Lombard */
public class Utils {

  public static BeerStyle alcoholToStyle(Float alcohol) {
    if (alcohol < 6) {
      return BeerStyle.MILD;
    } else if (alcohol > 7.2) {
      return BeerStyle.STRONG;
    }

    return BeerStyle.MEDIUM;
  }
}
