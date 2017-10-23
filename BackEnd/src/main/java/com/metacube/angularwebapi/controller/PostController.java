
package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dto.PostsDto;

import com.metacube.angularwebapi.facade.post.PostFacade;
import com.metacube.angularwebapi.spring.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostFacade postFacade;


        @RequestMapping(value = "", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody PostsDto addPost(@RequestBody PostsDto post) {
            System.out.println(post.toString());
            return postFacade.addPost(post);
                
	}
        
        @RequestMapping(value = "", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody PostsDto updatePost(@RequestBody PostsDto post) {
            System.out.println(post.toString());
            return postFacade.updatePost(post);
                
	}
        
        @RequestMapping(value = "", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Iterable<PostsDto> getPosts() {

            return postFacade.getAllPosts();

	}
        
        @RequestMapping(value = "/{postId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody PostsDto getPost(@PathVariable("postId") int postId) {
                return postFacade.getPostByUserId(postId);
                
	}
        
        
        @RequestMapping(value = "", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody PostsDto deletePost(@PathVariable("postId") int postId) {
                System.out.println(postId);
                return postFacade.deletePost(postId);
                
	}
        
}
