package com.metacube.angularwebapi.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.angularwebapi.dao.user.JdbcUserDao;
import com.metacube.angularwebapi.facade.user.DefaultUserFacade;
import com.metacube.angularwebapi.facade.user.UserFacade;
import com.metacube.angularwebapi.service.DefaultUserService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;


@Path("/users")
public class UserController
{
    private UserFacade userFacade;

    public UserController() {
        userFacade = new DefaultUserFacade(new DefaultUserService(new JdbcUserDao()));
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@Context UriInfo uriInfo) {
        
        MultivaluedMap<String, String> querymap = uriInfo.getQueryParameters();
        return Response.status(Response.Status.OK).entity(userFacade.getUsers(querymap)).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {

        return Response.status(Response.Status.OK).entity(userFacade.getUserById(id)).build();

    }
}
