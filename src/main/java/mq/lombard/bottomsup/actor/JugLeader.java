package mq.lombard.bottomsup.actor;

/** @author Pascal Lombard */
public class JugLeader extends Drinker {
  @Override
  public String drink() {
    getGlass().setToRefill(true);
    getDrank().add(getGlass().getBeerName());
    return "Et glou, [" + getName() + "] ! (Mais c'était meilleur à DevoxxBE)";
  }
}
