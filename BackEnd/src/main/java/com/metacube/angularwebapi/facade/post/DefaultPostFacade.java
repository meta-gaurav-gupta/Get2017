package com.metacube.angularwebapi.facade.post;

import com.metacube.angularwebapi.dto.PostsDto;
import com.metacube.angularwebapi.model.Post;
import com.metacube.angularwebapi.service.PostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("postFacade")
public class DefaultPostFacade implements PostFacade{
    @Autowired
    private PostService postService;

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public DefaultPostFacade() {
        
    }
    
    public DefaultPostFacade(PostService postService) {
            this.postService = postService;
    }

    protected Post dtoToModel(PostsDto postDto) {
            if (postDto == null) {
                    return null;
            }
            Post post = new Post();
            post.setId(postDto.getId());
            post.setUserId(postDto.getUserId());
            post.setUserName(postDto.getUserName());
            post.setBody(postDto.getBody());
            return post;
    }

    protected PostsDto modelToDto(Post post) {
            if (post == null) {
                    return null;
            }
            PostsDto postDto = new PostsDto();
            postDto.setId(post.getId());
            postDto.setUserId(post.getUserId());
            postDto.setUserName(post.getUserName());
            postDto.setBody(post.getBody());
            return postDto;
    }

    @Override
    public Iterable<PostsDto> getAllPosts() {
        List<PostsDto> postDtoList = new ArrayList<>();

		for (Post post : postService.getAllPosts()) {
			postDtoList.add(modelToDto(post));
		}

		return postDtoList;
    }

    @Override
    public PostsDto getPostByUserId(int userId) {
        
        return modelToDto(postService.getPostByUserId(userId));
        
    }

    @Override
    public PostsDto addPost(PostsDto post) {
        System.out.println(post.toString());
        return modelToDto(postService.addPost(dtoToModel(post)));
    }

    @Override
    public PostsDto updatePost(PostsDto post) {
        return modelToDto(postService.updatePost(dtoToModel(post)));
    }

    @Override
    public PostsDto deletePost(int postId) {
        System.out.println(postId);
        return modelToDto(postService.deletePost(postId));
    }
}
