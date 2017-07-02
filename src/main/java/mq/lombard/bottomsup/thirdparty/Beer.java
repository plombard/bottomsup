package mq.lombard.bottomsup.thirdparty;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/** @author Pascal Lombard */
@JsonInclude(NON_DEFAULT)
public final class Beer {

  private UUID id;
  private String name;
  private String description;
  private float alcohol;

  public Beer() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getAlcohol() {
    return alcohol;
  }

  public void setAlcohol(float alcohol) {
    this.alcohol = alcohol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Beer beer = (Beer) o;
    return Float.compare(beer.alcohol, alcohol) == 0
        && Objects.equals(id, beer.id)
        && Objects.equals(name, beer.name)
        && Objects.equals(description, beer.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, alcohol);
  }

  @Override
  public String toString() {
    return "mq.lombard.bottomsup.thirdparty.Beer{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", alcohol="
        + alcohol
        + '}';
  }
}
