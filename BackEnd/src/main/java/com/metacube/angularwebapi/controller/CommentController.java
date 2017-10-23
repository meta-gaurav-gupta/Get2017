package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dao.comment.JdbcCommentDao;
import com.metacube.angularwebapi.dto.CommentsDto;
import com.metacube.angularwebapi.facade.comment.CommentFacade;
import com.metacube.angularwebapi.facade.comment.DefaultCommentFacade;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.angularwebapi.service.DefaultCommentService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/comments")
public class CommentController {
    private CommentFacade commentFacade;

    public CommentController() {
        commentFacade = new DefaultCommentFacade(new DefaultCommentService(new JdbcCommentDao()));
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(CommentsDto comment) {
        
        return Response.status(Response.Status.OK).entity(commentFacade.addComments(comment)).build();

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments(@Context UriInfo uriInfo) {
        
        MultivaluedMap<String,String> queryMap = uriInfo.getQueryParameters();
        return Response.status(Response.Status.OK).entity(commentFacade.getComments(queryMap)).build();

    }
}
