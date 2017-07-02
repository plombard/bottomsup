package mq.lombard.bottomsup.thirdparty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toConcurrentMap;

/** @author Pascal Lombard */
public final class BeerApi {

  private static ConcurrentMap<String, Beer> beers = new ConcurrentHashMap<>();

  private static void importBeersIfNeeded() {
    if (beers.isEmpty()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        URL beersUrl = BeerApi.class.getClassLoader().getResource("beers.json");
        List<Beer> beerList = mapper.readValue(beersUrl, new TypeReference<List<Beer>>() {});
        beers.putAll(beerList.stream().collect(toConcurrentMap(Beer::getName, identity())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static Beer get(String name) {
    importBeersIfNeeded();
    return beers.get(name);
  }

  public static Set<Beer> list() {
    importBeersIfNeeded();
    return new HashSet<>(beers.values());
  }
}
