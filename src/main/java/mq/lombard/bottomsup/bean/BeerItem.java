package mq.lombard.bottomsup.bean;

import java.util.Objects;

/** @author Pascal Lombard */
public class BeerItem {
  private String beerName;
  private String description;
  private BeerStyle style;

  public BeerItem(String beerName, String description, BeerStyle style) {
    this.beerName = beerName;
    this.description = description;
    this.style = style;
  }

  public String getBeerName() {
    return beerName;
  }

  public void setBeerName(String beerName) {
    this.beerName = beerName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BeerStyle getStyle() {
    return style;
  }

  public void setStyle(BeerStyle style) {
    this.style = style;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BeerItem beerItem = (BeerItem) o;
    return Objects.equals(beerName, beerItem.beerName)
        && Objects.equals(description, beerItem.description)
        && style == beerItem.style;
  }

  @Override
  public int hashCode() {
    return Objects.hash(beerName, description, style);
  }

  @Override
  public String toString() {
    return "mq.lombard.bottomsup.bean.BeerItem{"
        + "beerName='"
        + beerName
        + '\''
        + ", description='"
        + description
        + '\''
        + ", style="
        + style
        + '}';
  }
}
