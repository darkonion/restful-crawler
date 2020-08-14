package controller;

import logic.DataHarvester;
import model.Hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class MainController {

    private final DataHarvester testSelenium;

    public MainController(DataHarvester testSelenium) {
        this.testSelenium = testSelenium;
    }

    @GET
    @Path("search")
    public List<Hotel> firstTest(@QueryParam("query") Optional<String> query) {
        return testSelenium.getHotels(query.orElse("Dubai"));
    }
}
