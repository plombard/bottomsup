package mq.lombard.bottomsup.actor;

import mq.lombard.bottomsup.bean.Glass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** @author Pascal Lombard */
public abstract class Drinker {

  private String name;
  private String organization;
  private Glass glass;
  private Integer paid = 0; // drinks paid for
  private List<String> drank = new ArrayList<>();

  public abstract String drink();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Glass getGlass() {
    return glass;
  }

  public void setGlass(Glass glass) {
    this.glass = glass;
  }

  public Integer getPaid() {
    return paid;
  }

  public void setPaid(Integer paid) {
    this.paid = paid;
  }

  public List<String> getDrank() {
    return drank;
  }

  public void setDrank(List<String> drank) {
    this.drank = drank;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Drinker drinker = (Drinker) o;
    return Objects.equals(name, drinker.name)
        && Objects.equals(organization, drinker.organization)
        && Objects.equals(glass, drinker.glass)
        && Objects.equals(paid, drinker.paid)
        && Objects.equals(drank, drinker.drank);
  }

  @Override
  public String toString() {
    return "mq.lombard.bottomsup.actor.Drinker{"
        + "name='"
        + name
        + '\''
        + ", organization='"
        + organization
        + '\''
        + ", glass="
        + glass
        + ", paid="
        + paid
        + ", drank="
        + drank
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, organization, glass, paid, drank);
  }

  public void pay(Integer drinks) {
    this.paid += drinks;
  }

  public void fillGlass() {
    this.glass.setToRefill(false);
  }
}
