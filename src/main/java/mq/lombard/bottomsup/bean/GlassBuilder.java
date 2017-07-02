package mq.lombard.bottomsup.bean;

public class GlassBuilder {
  private String beerName;
  private BeerStyle beerStyle;
  private boolean toRefill = true;

  public GlassBuilder setBeerName(String beerName) {
    this.beerName = beerName;
    return this;
  }

  public GlassBuilder setBeerStyle(BeerStyle beerStyle) {
    this.beerStyle = beerStyle;
    return this;
  }

  public GlassBuilder setToRefill(boolean toRefill) {
    this.toRefill = toRefill;
    return this;
  }

  public Glass build() {
    return new Glass(beerName, beerStyle, toRefill);
  }
}
