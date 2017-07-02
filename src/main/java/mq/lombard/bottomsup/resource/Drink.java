package mq.lombard.bottomsup.resource;

import mq.lombard.bottomsup.actor.Table;
import mq.lombard.bottomsup.business.BeerHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/** @author Pascal Lombard */
@Path("/")
public class Drink {

  @Path("/bottomsup")
  @POST
  @Produces(APPLICATION_JSON)
  public Response bottomsUp() {
    return Response.ok(Table.getInstance().bottomsUp()).build();
  }

  @Path("/table")
  @GET
  @Produces(APPLICATION_JSON)
  public Response table() {
    return Response.ok(Table.getInstance().drinkers()).build();
  }

  @Path("/oneround")
  @POST
  @Produces(APPLICATION_JSON)
  public Response oneRound(@QueryParam("name") String name, @QueryParam("beer") String beerName) {
    Table.getInstance().oneRound(name, beerName);
    return Response.ok().build();
  }

  @Path("/beers")
  @GET
  @Produces(APPLICATION_JSON)
  public Response beers() {
    return Response.ok(BeerHandler.getInstance().list()).build();
  }
}
