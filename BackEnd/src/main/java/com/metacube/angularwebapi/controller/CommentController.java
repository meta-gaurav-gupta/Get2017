package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dto.CommentsDto;
import com.metacube.angularwebapi.facade.comment.CommentFacade;

import com.metacube.angularwebapi.spring.Factory;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/comments")
public class CommentController {

    
    @Autowired
    private CommentFacade commentFacade;


        @RequestMapping(value = "", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody CommentsDto addComment(@RequestBody CommentsDto comment) {
            System.out.println(comment.toString());
            return commentFacade.addComments(comment);
                
	}
//	@GET
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getComments() {
//
//		return Response.status(Response.Status.OK).entity(commentFacade.getAllComments()).build();
//
//	}
        
        @RequestMapping(value = "", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Iterable<CommentsDto> getComments(@RequestParam Map<String,String> queryMap) {
            
            return commentFacade.getComments(queryMap);
            
	}
}
