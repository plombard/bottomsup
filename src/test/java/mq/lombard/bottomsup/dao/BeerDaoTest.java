package mq.lombard.bottomsup.dao;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

/** @author Pascal Lombard */
public class BeerDaoTest {
  @Test
  public void getBeer() {
    assertTrue(
        "Chimay Rouge not found",
        Objects.equals(
            "Chimay " + "Rouge", BeerDao.getInstance().getBeer("Chimay Rouge").getName()));
  }

  @Test
  public void listBeers() {
    assertTrue("Beer List not complete", BeerDao.getInstance().listBeers().size() == 4);
  }
}
