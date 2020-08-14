package controller;

import logic.DataHarvester;
import model.Hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api")
@Produces(APPLICATION_JSON)
public class MainController {

    private final DataHarvester dataHarvester;

    public MainController(DataHarvester dataHarvester) {
        this.dataHarvester = dataHarvester;
    }

    @GET
    @Path("search")
    public List<Hotel> firstTest(@QueryParam("query") Optional<String> query) {
        return dataHarvester.getHotels(query.orElse("Dubai"));
    }
}
