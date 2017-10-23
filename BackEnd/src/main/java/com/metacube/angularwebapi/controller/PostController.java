
package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dao.post.JdbcPostDao;
import com.metacube.angularwebapi.dto.PostsDto;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.angularwebapi.facade.post.DefaultPostFacade;
import com.metacube.angularwebapi.facade.post.PostFacade;
import com.metacube.angularwebapi.service.DefaultPostService;
import com.metacube.angularwebapi.spring.Factory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;


@Path("/posts")
public class PostController {
    
    private PostFacade postFacade;

	public PostController() {
            postFacade = Factory.getApplicationContext().getBean("postFacade",PostFacade.class);
	}

        @POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	public Response addPost(PostsDto post) {
            System.out.println(post.toString());
            return Response.status(Response.Status.OK).entity(postFacade.addPost(post)).build();
                
	}
        
        @PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	public Response updatePost(PostsDto post) {
            System.out.println(post.toString());
            return Response.status(Response.Status.OK).entity(postFacade.updatePost(post)).build();
                
	}
        
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPosts() {

            return Response.status(Response.Status.OK).entity(postFacade.getAllPosts()).build();

	}
        
        @GET
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPost(@PathParam("postId") int postId) {
                return Response.status(Response.Status.OK).entity(postFacade.getPostByUserId(postId)).build();
                
	}
        
        
        @DELETE
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePost(@PathParam("postId") int postId) {
                System.out.println(postId);
                return Response.status(Response.Status.OK).entity(postFacade.deletePost(postId)).build();
                
	}
        
}
