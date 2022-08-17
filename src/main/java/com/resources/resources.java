package com.resources;
import com.example.parkingsystemv1.Objects.Registration;
import com.example.parkingsystemv1.Objects.parking;
import com.example.parkingsystemv1.localDatabase.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Objects;

import static com.example.parkingsystemv1.Controller.Controller.*;

@Path("/end-point")
public class resources {

    @POST
    @Path("/registration")
    public Response Registration(String payload) throws Exception {

            Registration new_entry = new Gson().fromJson(payload, Registration.class);

            int result = doRegistration(new_entry);

            if (result == 1) {
                return Response.status(400).entity("in valid input").build();
            } else if (result == 2) {
                return Response.ok("already registered").build();
            } else //if (result == 3) {
                return Response.ok("successfully registered").build();
    }

    @POST
    @Path("parking")
    public Response Parking(String payload) throws Exception {
        System.out.println(payload);
            parking new_status = new Gson().fromJson(payload, parking.class);
            int result = doParking(new_status);
            if (result == 1) {
                return Response.status(400).entity("invalid data").build();
            } else if (result == 2) {
                return Response.ok().status(200).entity("you have already parked in").build();
            } else if (result == 3) {
                return Response.ok().status(200).entity("you have already parked out").build();
            } else if (result == 4) {
                return Response.ok().status(200).entity("you have successfully parked in").build();
            } else if (result == 5) {
                return Response.ok().status(200).entity("you have successfully parked out").build();
            } else // if (result == 8)
            {
                return Response.status(400).entity("first register your car then do parking").build();
            }
    }

    @GET
    @Path("park_history")
    public Response History(@QueryParam("vehicle-name") String name) throws SQLException {
            Database db = new Database();
            int check = db.check_registration(name);
            if( check == 1) {
                return Response.status(200).entity("this car is not registered yet").build();}
            else {
                String output = carHistory(name);
                System.out.println(output);
                if(!Objects.equals(output, ""))
                {
                    return Response.ok().status(400).entity(output).build();
                }
                else
                {
                    return Response.status(200).entity("not parked yet, hence no parking history").build();
                }
            }
    }
}

