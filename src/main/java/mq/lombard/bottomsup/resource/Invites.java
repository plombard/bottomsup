package mq.lombard.bottomsup.resource;

import mq.lombard.bottomsup.actor.DrinkStrategiesKt;
import mq.lombard.bottomsup.actor.Drinker;
import mq.lombard.bottomsup.actor.Table;
import mq.lombard.bottomsup.business.BeerHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Objects;
import java.util.Set;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/** @author Pascal Lombard */
@Path("/")
public class Invites {

  @Path("/invite")
  @POST
  @Produces(APPLICATION_JSON)
  public Response inviteMember(@QueryParam("beer") String beerName, Drinker
      member) {
    if (Objects.isNull(member.getGlass())) {
      member.setGlass(BeerHandler.INSTANCE.pour(beerName));
    }
    member.setDrinkStrategy(DrinkStrategiesKt.getMemberDrinkStrategy());
    Set<Drinker> drinkers = Table.getInstance().add(member);
    return Response.ok(drinkers).build();
  }

  @Path("/leader")
  @POST
  @Produces(APPLICATION_JSON)
  public Response inviteLeader(@QueryParam("beer") String beerName, Drinker
      leader) {
    if (Objects.isNull(leader.getGlass())) {
      leader.setGlass(BeerHandler.INSTANCE.pour(beerName));
    }
    leader.setDrinkStrategy(DrinkStrategiesKt.getLeaderDrinkStrategy());
    Set<Drinker> drinkers = Table.getInstance().add(leader);
    return Response.ok(drinkers).build();
  }

  @Path("/invite")
  @DELETE
  @Produces(APPLICATION_JSON)
  public Response getOut(@QueryParam("name") String name) {
    if (Table.getInstance().uninvite(name)) {
      return Response.ok(Table.getInstance().drinkers()).build();
    } else {
      return Response.noContent().build();
    }
  }
}
