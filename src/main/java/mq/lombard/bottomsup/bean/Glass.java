package mq.lombard.bottomsup.bean;

import java.util.Objects;

/** @author Pascal Lombard */
public class Glass {

  private String beerName;
  private BeerStyle beerStyle;
  private boolean toRefill = true;

  public Glass() {}

  public Glass(String beerName, BeerStyle beerStyle) {
    this.beerName = beerName;
    this.beerStyle = beerStyle;
  }

  public Glass(String beerName, BeerStyle beerStyle, boolean toRefill) {
    this.beerName = beerName;
    this.beerStyle = beerStyle;
    this.toRefill = toRefill;
  }

  public String getBeerName() {
    return beerName;
  }

  public void setBeerName(String beerName) {
    this.beerName = beerName;
  }

  public BeerStyle getBeerStyle() {
    return beerStyle;
  }

  public void setBeerStyle(BeerStyle beerStyle) {
    this.beerStyle = beerStyle;
  }

  public boolean isToRefill() {
    return toRefill;
  }

  public void setToRefill(boolean toRefill) {
    this.toRefill = toRefill;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Glass glass = (Glass) o;
    return toRefill == glass.toRefill
        && Objects.equals(beerName, glass.beerName)
        && Objects.equals(beerStyle, glass.beerStyle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beerName, beerStyle, toRefill);
  }

  @Override
  public String toString() {
    return "mq.lombard.bottomsup.bean.Glass{"
        + "beerName='"
        + beerName
        + '\''
        + ", beerStyle="
        + beerStyle
        + ", toRefill="
        + toRefill
        + '}';
  }
}
