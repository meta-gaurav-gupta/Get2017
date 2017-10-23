
package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dto.PostsDto;

import com.metacube.angularwebapi.facade.post.PostFacade;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@CrossOrigin(origins = "*")
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
        
        
        @RequestMapping(produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody PostsDto deletePost(@PathVariable("postId") int postId) {
                System.out.println(postId);
                return postFacade.deletePost(postId);
                
	}
        
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }
        
}
