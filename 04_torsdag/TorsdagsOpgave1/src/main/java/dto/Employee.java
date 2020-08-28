/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author groen
 */
@Path("employee")
public class Employee {

    @Context
    private UriInfo context;

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static List<EmployeeDTO> employee = new ArrayList();
   
    /**
     * Creates a new instance of CarResource
     */
   
    public Employee() {
        if(employee.isEmpty()){
            employee.add(new EmployeeDTO(1, "Christensen","lolstreet 1"));
            employee.add(new EmployeeDTO(1, "Christensen","lolstreet 1"));
            employee.add(new EmployeeDTO(1, "Christensen","lolstreet 1"));
        }
    }
    /**
     * Retrieves representation of an instance of dto.ApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
