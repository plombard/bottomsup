package mq.lombard.bottomsup.thirdparty;

import org.junit.Test;

import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/** @author Pascal Lombard */
public class BeerApiTest {
  @Test
  public void get() throws Exception {
    Beer beer = new Beer();
    beer.setName("Affligem Tripel");
    beer.setDescription(
        "The king of the abbey beers. It is amber-gold and pours with a deep head and original aroma, delivering a complex, full bodied flavour. Pure enjoyment! Secondary fermentation in the bottle.");
    beer.setId(UUID.fromString("5ea38d0f-0624-4dc9-bc6c-fb3eab2b0495"));
    beer.setAlcohol(8.5F);
    assertTrue("Affligem Tripel not found", Objects.equals(BeerApi.get("Affligem Tripel"), beer));
  }

  @Test
  public void list() throws Exception {
    assertTrue("Beer list is incomplete", BeerApi.list().size() == 4);
  }
}
