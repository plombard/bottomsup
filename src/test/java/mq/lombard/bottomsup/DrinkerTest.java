package mq.lombard.bottomsup;

import mq.lombard.bottomsup.actor.Drinker;
import mq.lombard.bottomsup.bean.BeerStyle;
import mq.lombard.bottomsup.bean.Glass;
import org.junit.Before;
import org.junit.Test;

import static mq.lombard.bottomsup.actor.DrinkStrategiesKt
    .getLeaderDrinkStrategy;
import static org.junit.Assert.assertTrue;

/** @author Pascal Lombard */
public class DrinkerTest {

  private Drinker leader;
  private Drinker member;

  @Before
  public void setUp() throws Exception {
    leader = new Drinker("Optimus", "FinistJUG");
    leader.setGlass(new Glass("Rochefort 8", BeerStyle.STRONG));
    leader.setDrinkStrategy(getLeaderDrinkStrategy());

    member = new Drinker("Bumblebee", "FinistJUG");
    member.setGlass(new Glass("Chimay Rouge", BeerStyle.MEDIUM));
  }

  @Test
  public void drink() throws Exception {
    assertTrue(
        "Leader didn't drink a Rochefort 8 as a leader", leader.drink().contains("DevoxxBE"));
    assertTrue("Leader hasn't consumed a beer", !leader.getDrank().isEmpty());
    assertTrue("Leader hasn't consumed just one beer", leader.getDrank().size() == 1);

    assertTrue("Member didn't drink as a member", member.drink().endsWith("] !"));
    assertTrue("Member hasn't consumed a beer", !member.getDrank().isEmpty());
    assertTrue("Member hasn't consumed just one beer", member.getDrank().size() == 1);
  }

  @Test
  public void pay() throws Exception {
    leader.pay(4);
    assertTrue("Drinker should have pay 4 drinks", leader.getPaid() == 4);
  }

  @Test
  public void fillGlass() throws Exception {
    leader.fillGlass();
    assertTrue("Leader's glass wsn't filled correctly", !leader.getGlass()
        .getToRefill());
  }
}
