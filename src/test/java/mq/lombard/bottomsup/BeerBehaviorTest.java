package mq.lombard.bottomsup;

import mq.lombard.bottomsup.bean.BeerStyle;
import mq.lombard.bottomsup.bean.Glass;
import mq.lombard.bottomsup.business.BeerHandler;
import mq.lombard.bottomsup.thirdparty.Beer;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/** @author Pascal Lombard */
public class BeerBehaviorTest {

  private Beer beer;
  private Glass expectedGlass;

  @Before
  public void setUp() {
    beer = new Beer();
    beer.setId(UUID.fromString("3abdf459-57c1-4c15-adcd-b3846da5a402"));
    beer.setName("Rochefort 8");
    beer.setDescription("A dry but rich flavoured beer with complex fruity and spicy flavours.");
    beer.setAlcohol(8.0F);

    expectedGlass =
        new Glass("Rochefort 8", BeerStyle.STRONG, false);
  }

  @Test
  public void pour() throws Exception {
    assertTrue(
        "The beer poured is no Rochefort 8 in the glass",
        Objects.equals(BeerHandler.INSTANCE.pour(beer.getName()),
            expectedGlass));
  }

  @Test
  public void list() throws Exception {
    assertTrue("Wrong number of beers", BeerHandler.INSTANCE.list().size() == 4);
  }
}
