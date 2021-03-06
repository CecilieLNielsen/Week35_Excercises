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
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cecilie
 */
@Path("point")
public class GenericResource {
    Facade facade = new Facade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create;
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        //TODO return proper representation object
        return "{\"message\":\"hello\"}";
    }
    
     @GET
     @Path("/all")
     @Produces(MediaType.APPLICATION_JSON)
     public String getAllPoints()   {
         List<Points> points = facade.getAll();
         gson.toJson(points);
         return Response.ok().entity(jsonout).build();
     }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
}
