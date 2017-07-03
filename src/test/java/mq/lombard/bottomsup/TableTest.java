package mq.lombard.bottomsup;

import mq.lombard.bottomsup.actor.Drinker;
import mq.lombard.bottomsup.actor.JugLeader;
import mq.lombard.bottomsup.actor.JugMember;
import mq.lombard.bottomsup.actor.Table;
import mq.lombard.bottomsup.bean.BeerStyle;
import mq.lombard.bottomsup.bean.Glass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/** @author Pascal Lombard */
public class TableTest {

  private JugLeader leader;
  private JugMember member;

  @Before
  public void setUp() throws Exception {
    leader = new JugLeader();
    leader.setGlass(new Glass("Rochefort 8", BeerStyle.STRONG));
    leader.setOrganization("FinisJUG");
    leader.setName("Optimus");
    member = new JugMember();
    member.setGlass(new Glass("Chimay Rouge", BeerStyle.MEDIUM));
    member.setOrganization("FinisJUG");
    member.setName("Bumblebee");
  }

  @After
  public void tearDown() throws Exception {
    Table.getInstance().clear();
  }

  @Test
  public void add() throws Exception {
    assertTrue("Leader wasn't added correctly", Table.getInstance().add(leader).contains(leader));
    assertTrue("Member wasn't added correctly", Table.getInstance().add(member).contains(member));
  }

  @Test
  public void drinkers() throws Exception {
    Table.getInstance().add(leader);
    Table.getInstance().add(member);
    assertTrue("Drinkers wasn't retrieved correctly", Table.getInstance().drinkers().size() == 2);
  }

  @Test
  public void getDrinker() throws Exception {
    Table.getInstance().add(leader);
    Table.getInstance().add(member);
    assertTrue(
        "Leader wasn't retrieved correctly", Table.getInstance().getDrinker("Optimus").isPresent());
    assertTrue(
        "Member wasn't retrieved correctly",
        Table.getInstance().getDrinker("Bumblebee").isPresent());
  }

  @Test
  public void bottomsUp() throws Exception {
    Table.getInstance().add(leader);
    Table.getInstance().add(member);
    assertTrue(
        "Glasses weren't emptied in due course", Table.getInstance().bottomsUp().size() == 2);
    assertTrue(
        "Glasses aren't all empty",
        Table.getInstance()
                .drinkers()
                .stream()
            .filter(drinker -> drinker.getGlass().getToRefill())
                .count()
            == 2);
  }

  @Test
  public void oneRound() throws Exception {
    Table.getInstance().add(leader);
    Table.getInstance().add(member);
    Table.getInstance().bottomsUp();
    Table.getInstance().oneRound("Optimus", "Affligem Tripel");
    assertTrue(
        "Leader hasn't pay his round correctly",
        Table.getInstance().getDrinker("Optimus").map(Drinker::getPaid)
            .orElse(0) == 3);
    assertTrue(
        "All glasses aren't full",
        Table.getInstance()
            .drinkers()
            .stream()
            .noneMatch(drinker -> drinker.getGlass().getToRefill()));
  }

  @Test
  public void uninvite() throws Exception {
    Table.getInstance().add(leader);
    Table.getInstance().add(member);
    assertTrue("Member wasn't uninvited correctly", Table.getInstance().uninvite("Bumblebee"));
  }
}
