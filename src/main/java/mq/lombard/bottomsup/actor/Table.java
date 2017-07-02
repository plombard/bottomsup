package mq.lombard.bottomsup.actor;

import mq.lombard.bottomsup.business.BeerHandler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/** @author Pascal Lombard */
public class Table {
  private static Table ourInstance = new Table();
  private Set<Drinker> drinkers = new HashSet<>();

  private Table() {}

  public static Table getInstance() {
    return ourInstance;
  }

  public Set<Drinker> add(Drinker drinker) {
    drinker.fillGlass();
    drinker.pay(1);
    drinkers.add(drinker);
    return new HashSet<>(drinkers);
  }

  public Set<Drinker> drinkers() {
    return new HashSet<>(drinkers);
  }

  public Optional<Drinker> getDrinker(String name) {
    return drinkers.stream().filter(drinker -> drinker.getName().equalsIgnoreCase(name)).findAny();
  }

  public Set<String> bottomsUp() {
    return drinkers.stream().map(Drinker::drink).collect(toSet());
  }

  public void oneRound(String name, String beerName) {
    Long toPay = drinkers.stream().filter(drinker -> drinker.getGlass().isToRefill()).count();
    getDrinker(name).ifPresent(drinker1 -> drinker1.pay(toPay.intValue()));
    drinkers
        .stream()
        .filter(drinker -> drinker.getGlass().isToRefill())
        .forEach(drinker -> drinker.setGlass(BeerHandler.INSTANCE.pour
            (beerName)));
  }

  public Boolean uninvite(String name) {
    return drinkers.removeIf(drinker -> drinker.getName().equalsIgnoreCase(name));
  }

  public void clear() {
    drinkers.clear();
  }
}
