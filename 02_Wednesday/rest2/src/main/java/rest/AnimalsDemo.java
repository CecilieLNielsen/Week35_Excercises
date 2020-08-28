/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author cecilie
 */
@Path("animals")
public class AnimalsDemo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalsDemo
     */
    public AnimalsDemo() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalsDemo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "vuf... (Message from a dog)";

    }

    @GET
    @Path("/animal_list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimals() {
        return "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";

    }

    @GET
    @Path("/animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalsTypesAndSounds() {
        AnimalNoDB animal = new AnimalNoDB("Dog", "Bark");
        return new Gson().toJson(animal);

    }

}
